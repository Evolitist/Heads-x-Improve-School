package com.example.lesson11

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import com.google.android.material.color.MaterialColors
import kotlin.math.abs
import kotlin.math.min
import kotlin.math.roundToInt

class CustomView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet?,
    defAttrs: Int = 0
) : View(context, attributeSet, defAttrs) {

    private val paint = Paint().apply {
        color = MaterialColors.getColor(context, R.attr.colorPrimary, Color.BLACK)
        strokeWidth = 5F
    }

    private val points = mutableListOf(0F, 0F, 0F, 0F, 0F)
    private var pointsMargin = 0F
    private var currentlyTouchedPointIndex: Int? = null

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        val heightCenter = height / 2F
        val widthCenter = width / 2F
        drawAxis(canvas, heightCenter, widthCenter)
        drawPointsAndColumns(canvas, heightCenter, widthCenter)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = suggestedMinimumWidth + paddingStart + paddingEnd
        val desiredHeight = suggestedMinimumHeight + paddingTop + paddingBottom

        setMeasuredDimension(
            measureDimension(desiredWidth, widthMeasureSpec),
            measureDimension(desiredHeight, heightMeasureSpec)
        )
    }

    private fun measureDimension(desiredSize: Int, measureSpec: Int): Int {
        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)
        if (specMode == MeasureSpec.UNSPECIFIED) throw IllegalArgumentException("Unspecified")
        return if (specMode == MeasureSpec.EXACTLY) {
            specSize
        } else {
            if (specMode == MeasureSpec.AT_MOST) {
                min(desiredSize, specSize)
            } else {
                desiredSize
            }
        }
    }

    private fun drawAxis(canvas: Canvas, hCenter: Float, wCenter: Float) {
        canvas.run {
            drawLine(
                wCenter,
                0F,
                wCenter,
                height.toFloat(),
                paint
            )
            drawLine(
                0F,
                hCenter,
                width.toFloat(),
                hCenter,
                paint
            )
        }
    }

    private fun drawPointsAndColumns(canvas: Canvas, hCenter: Float, wCenter: Float) {
        var cy: Float
        var cx = wCenter
        canvas.run {
            points.forEach { point ->
                cy = hCenter + (hCenter * point)
                drawCircle(
                    cx,
                    cy,
                    POINT_RADIUS,
                    paint
                )

                val rect = if (cy < hCenter) {
                    RectF().apply {
                        set(
                            cx - POINT_RADIUS,
                            cy,
                            cx + POINT_RADIUS,
                            hCenter
                        )
                    }
                } else {
                    RectF().apply {
                        set(
                            cx - POINT_RADIUS,
                            hCenter,
                            cx + POINT_RADIUS,
                            cy
                        )
                    }
                }
                drawRect(rect, paint)
                cx += pointsMargin
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val clickedX = event.x
        val clickedY = event.y
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                val centerWidth = width / 2F
                currentlyTouchedPointIndex = ((clickedX - centerWidth) / pointsMargin).roundToInt()
                currentlyTouchedPointIndex?.let {
                    if ((it < 0) || (abs(clickedX - centerWidth - pointsMargin * it) > POINT_RADIUS*2)) {
                        return false
                    }
                    points[it] = (clickedY / height - 0.5F) * 2
                    invalidate()
                    return true
                }
            }
            MotionEvent.ACTION_MOVE -> {
                currentlyTouchedPointIndex?.let {
                    points[it] = (clickedY / height - 0.5F) * 2
                    invalidate()
                    return true
                }
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                currentlyTouchedPointIndex = null
            }
        }

        return super.onTouchEvent(event)
    }

    fun setPoints(newPoints: List<Float>) {
        if (newPoints.size != 5) throw IllegalArgumentException()
        val oldValues = points
        pointsMargin = (width / 2F) / newPoints.size

        repeat(points.size) { counter ->
            ValueAnimator().apply {
                duration = 1000
                interpolator = AccelerateDecelerateInterpolator()
                setFloatValues(oldValues[counter], newPoints[counter])
                addUpdateListener { animator ->
                    val newValue = animator.animatedValue as Float
                    points[counter] = newValue
                    invalidate()
                }
                start()
            }
        }
        points.clear()
        points.addAll(newPoints)
    }

    companion object {
        const val POINT_RADIUS = 15F
    }
}