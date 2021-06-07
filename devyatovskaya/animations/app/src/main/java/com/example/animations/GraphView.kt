package com.example.animations

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

class GraphView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttrs: Int = 0,
        defStyleRes: Int = 0,
) : View(context, attrs, defStyleAttrs, defStyleRes) {

    private val axisPaint = Paint().apply {
        strokeWidth = 1f
        style = Paint.Style.STROKE
    }

    private val pointPaint = Paint()
    private val decorPaint = Paint().apply {
        style = Paint.Style.STROKE
    }

    private val pointerPointMap = mutableMapOf<Int, Int>()
    private val linePath = Path()
    private val countPoints = 5
    private var pointRadius = 0f
    private var xAxisPoint = 0f
    private var yAxisPoint = 0f
    private var pointSpacing = 0f


    private val _values = mutableListOf<Float>()
    var points = floatArrayOf(-0.7f, 0.3f, -0.3f, 0.0f, 0.5f)
        set(value) {
            field = value
            updateUI()
        }

    init {
        pointRadius = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                POINT_RADIUS_DP,
                context.resources.displayMetrics,
        )
        decorPaint.strokeWidth = pointRadius / 2
        val colorBuffer = TypedValue()
        context.theme.resolveAttribute(R.attr.colorOnSurface, colorBuffer, true)
        axisPaint.color = colorBuffer.data
        context.theme.resolveAttribute(R.attr.colorSecondary, colorBuffer, true)
        pointPaint.color = colorBuffer.data
        decorPaint.color = colorBuffer.data
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = sizeFromMeasureSpec(widthMeasureSpec)
        val height = sizeFromMeasureSpec(heightMeasureSpec)
        xAxisPoint = width / 2f
        yAxisPoint = height / 2f
        pointSpacing = (width - pointRadius.times(2)) / countPoints.dec()
        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        requireNotNull(canvas)
        canvas.drawLine(0f, yAxisPoint, measuredWidth.toFloat(), yAxisPoint, axisPaint)
        canvas.drawLine(xAxisPoint, 0f, xAxisPoint, measuredHeight.toFloat(), axisPaint)
        linePath.apply {
            reset()
            val controlPointStep = pointSpacing * 2 / 5
            var prevX = pointRadius
            var prevY = points[0] * yAxisPoint + yAxisPoint
            moveTo(prevX, prevY)
            repeat(countPoints - 1) {
                val i = it + 1
                val x = pointRadius + pointSpacing.times(i)
                val y = points[i] * yAxisPoint + yAxisPoint
                linePath.cubicTo(
                        prevX + controlPointStep, prevY,
                        x - controlPointStep, y,
                        x, y,
                )
                prevX = x
                prevY = y
            }
        }
        canvas.drawPath(linePath, decorPaint)
        repeat(countPoints) {
            val x = pointRadius + pointSpacing.times(it)
            val y = points[it] * yAxisPoint + yAxisPoint
            if (false) {
                canvas.drawRect(
                        x - pointRadius,
                        max(y, yAxisPoint),
                        x + pointRadius,
                        min(y, yAxisPoint),
                        decorPaint,
                )
            }
            canvas.drawCircle(x, y, pointRadius, pointPaint)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val index = event.actionIndex
        val x = event.x
        val y = event.y
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                val pointIndex = (x / pointSpacing).roundToInt()
                if (abs(x - pointSpacing * pointIndex) > pointRadius * 4) {
                    return false
                }
                pointerPointMap[index] = pointIndex
                points[pointIndex] = y / measuredHeight * 2f - 1f
                invalidate()
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                val pointIndex = pointerPointMap[index] ?: return false
                points[pointIndex] = y / measuredHeight * 2f - 1f
                invalidate()
                return true
            }
            MotionEvent.ACTION_UP -> {
                return pointerPointMap.remove(index) != null
            }
        }
        return super.onTouchEvent(event)
    }

    private fun getVerticalPositionNewPoint(point: Float): Float {
        return if (point < 0)
            (abs(point) * yAxisPoint) + yAxisPoint
        else
            yAxisPoint - (point * yAxisPoint)
    }

    private fun updateUI() {
        if (_values.isNotEmpty()) {
            val newValueY = points.map {
                getVerticalPositionNewPoint(it)
            }
            repeat(countPoints) { pointY ->
                val animator = ValueAnimator()
                animator.apply {
                    duration = 700
                    interpolator = AccelerateDecelerateInterpolator()
                    setFloatValues(_values[pointY], newValueY[pointY])
                    start()
                    addUpdateListener { animation ->
                        val animatedValue = animation.animatedValue as Float
                        _values[pointY] = animatedValue
                        invalidate()
                    }
                }
            }
        }
    }

    companion object {
        private const val POINT_RADIUS_DP = 4f

        private fun sizeFromMeasureSpec(measureSpec: Int): Int {
            val mode = MeasureSpec.getMode(measureSpec)
            require(mode == MeasureSpec.AT_MOST || mode == MeasureSpec.EXACTLY)
            return when (mode) {
                MeasureSpec.AT_MOST,
                MeasureSpec.EXACTLY -> MeasureSpec.getSize(measureSpec)
                else -> 0
            }
        }
    }
}