package com.example.last_lesson

import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.*
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateInterpolator


class Graph_view @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attrs, defStyle) {
    //
    var listt: FloatArray = floatArrayOf(1.0f, 0.1f, 0.0f, -0.3f, -1.0f)
        get() = field
        set(value) {
            Log.d("dbbd", listt.toString())
            field = value
            listHeightCalc()
            invalidate()
        }

    var listHeight: FloatArray = floatArrayOf()
    var listWidth: FloatArray = floatArrayOf()

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var borderColor = Color.BLACK
    private var fillColor = Color.RED

    private var size = 320

    private val countCircle = 5
    private var radius = dpToPx(4)

    fun sett(value: FloatArray) {
        Log.d("dbbd", value.toString())
        val objAnim = ObjectAnimator.ofObject(
            this,
            object : Property<Graph_view, FloatArray>(FloatArray::class.java, "li") {
                override fun get(`object`: Graph_view?): FloatArray {
                    return listt
                }

                override fun set(`object`: Graph_view?, value: FloatArray?) {
                    if (value != null) {
                        listt = value
                    }
                }
            },
            object : TypeEvaluator<FloatArray> {
                override fun evaluate(
                    fraction: Float,
                    startValue: FloatArray,
                    endValue: FloatArray
                ): FloatArray {
                    return FloatArray(5) {
                        startValue[it] + (endValue[it] - startValue[it]) * fraction
                    }
                }
            },
            value
        )
        objAnim.duration = 500
        objAnim.interpolator = AccelerateInterpolator()
        objAnim.start()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawBackground(canvas)
        drawCircle(canvas)
        drawLines(canvas)
    }

    private fun drawBackground(canvas: Canvas) {
        paint.color = borderColor

        canvas.drawLine(0f, size / 2f, size.toFloat(), size / 2f, paint)
        canvas.drawLine(size / 2f, 0f, size / 2f, size.toFloat(), paint)

    }

    private fun drawLines(canvas: Canvas) {
        repeat(countCircle) {
            val x = listWidth[it] - radius
            val y = listHeight[it]

            paint.color = fillColor
            paint.style = Paint.Style.FILL

            canvas.drawRect(x, size / 2f, x + 2f * radius, y, paint)
        }

    }

    private fun drawCircle(canvas: Canvas) {

        repeat(countCircle) {

            val x = listWidth[it]
            val y = listHeight[it]

            paint.color = fillColor
            paint.style = Paint.Style.FILL

            canvas.drawCircle(x, y, radius.toFloat(), paint)
        }

    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val desiredWidth = 100
        val desiredHeight = 100

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val width: Int
        val height: Int

        width = if (widthMode == MeasureSpec.EXACTLY) {
            widthSize
        } else if (widthMode == MeasureSpec.AT_MOST) {
            Math.min(desiredWidth, widthSize)
        } else {
            desiredWidth
        }
        height = when (heightMode) {
            MeasureSpec.EXACTLY -> heightSize
            MeasureSpec.AT_MOST -> Math.min(desiredHeight, heightSize)
            else -> desiredHeight
        }

        size = Math.min(width, height)
        setMeasuredDimension(size, size)

        val colorBuffer: TypedValue = TypedValue()
        context.theme.resolveAttribute(R.attr.colorOnSurface, colorBuffer, true)
        borderColor = colorBuffer.data
        context.theme.resolveAttribute(R.attr.colorSecondary, colorBuffer, true)
        fillColor = colorBuffer.data

        listWidthCalc()
        listHeightCalc()

    }

    fun listWidthCalc() {
        listWidth = FloatArray(countCircle) {
            if (it == 0) {
                radius.toFloat()
            } else {
                ((size - 2.0f * radius) / (countCircle - 1)) * it + radius
            }
        }
    }

    fun listHeightCalc() {
        val curSize = size - 2f * radius
        listHeight = FloatArray(countCircle) {
            (curSize / 2f) - listt[it] * (curSize / 2f) + radius
        }
    }

    fun dpToPx(dp: Int): Int {
        val displayMetrics: DisplayMetrics = this.resources.displayMetrics
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val pointerCount = event?.pointerCount

        if (pointerCount != null) {
            for (i in 0 until pointerCount) {
                val x = event.getX(i)
                val y = event.getY(i)
                var idd = 0

                for (j in 0 until countCircle) {
                    val s = (size - radius * 2f) / (countCircle - 1f)
                    if (x > j * s - s / 2f && x < j * s + s / 2f) {
                        idd = j
                    }
                }

                when (event.action and MotionEvent.ACTION_MASK) {
                    MotionEvent.ACTION_DOWN -> {
                        val yy = (size / 2f - y) / (size / 2f)
                        //Log.d("dbbd", yy.toString() +" 1")
                        listt[idd] = yy
                        listHeightCalc()
                        invalidate()
                        performClick()
                        return true
                    }
                    MotionEvent.ACTION_MOVE -> {
                        val yy = (size / 2f - y) / (size / 2f)
                        //Log.d("dbbd", yy.toString() + " 2")
                        listt[idd] = yy
                        listHeightCalc()
                        invalidate()
                        performClick()
                        return true
                    }
                }
            }
        }
        return super.onTouchEvent(event)
    }

    override fun performClick(): Boolean {
        return super.performClick()
    }

}