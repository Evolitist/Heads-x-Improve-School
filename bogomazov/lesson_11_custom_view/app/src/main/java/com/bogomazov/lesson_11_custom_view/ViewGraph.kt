package com.bogomazov.lesson_11_custom_view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import kotlin.math.abs
import kotlin.random.Random

class ViewGraph(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val paintPoint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paintAxis = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paintLine = Paint(Paint.ANTI_ALIAS_FLAG)
    private val linePath = Path()

    private var sizeVertical: Int = 0
    private var sizeHorizontal: Int = 0
    private var radiusPoint: Float = 0F
    private var stepPointsHorizontal: Float = 0F
    private var partHorizontalAxis: Float = 0F
    private var partVerticalAxis: Float = 0F
    private val listDrawPointPositionY = mutableListOf<Float>()

    var mainColor: Int = Color.BLACK
        set(color) {
            field = color
            invalidate()
        }

    var listPointUser: MutableList<Float> = mutableListOf(0F, 0F, 0F, 0F, 0F)
        set(value) {
            if (value.size != 5)
                throw Exception("The list must be 5 items")
            field = value
            updateUIGraph()
        }

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ViewGraph,
            0,
            0
        ).apply {
            mainColor = getColor(R.styleable.ViewGraph_color_line, Color.BLACK)
            radiusPoint = getDimension(
                R.styleable.ViewGraph_radius_point,
                resources.getDimension(R.dimen.default_radius_point)
            )
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        sizeHorizontal = resolveSize(widthMeasureSpec, widthMeasureSpec)
        sizeVertical = resolveSize(MIN_HEIGHT_VIEW_GRAPH, heightMeasureSpec)

        stepPointsHorizontal = sizeHorizontal / 4F
        partHorizontalAxis = sizeHorizontal / 2F
        partVerticalAxis = sizeVertical / 2F

        listDrawPointPositionY.clear()
        listPointUser.forEach {
            listDrawPointPositionY.add(
                getVerticalPositionNewPoint(it)
            )
        }

        setMeasuredDimension(sizeHorizontal, sizeVertical)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return detector.onTouchEvent(event).let { result ->
            if (!result) {
                if (event?.action == MotionEvent.ACTION_UP) {
                    detectTouchPointLineY(event.x, event.y)
                    true
                } else false
            } else true
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paintAxis.strokeWidth = 3f
        paintAxis.style = Paint.Style.STROKE
        paintAxis.color = mainColor

        drawVerticalLine(canvas)
        drawHorizontalLine(canvas)

        paintPoint.color = mainColor
        repeat(TOTAL_POINT) { index ->
            drawPoint(canvas, index)
        }

        paintLine.strokeWidth = 3f
        paintLine.style = Paint.Style.STROKE
        paintLine.color = mainColor

        repeat(4) { line ->
            drawCurves(canvas, line)
        }

    }

    private fun drawCurves(canvas: Canvas?, numberLine: Int) {
        linePath.apply {
            moveTo(stepPointsHorizontal * numberLine, listDrawPointPositionY[numberLine])
            cubicTo(
                (stepPointsHorizontal * numberLine) + stepPointsHorizontal / 2,
                listDrawPointPositionY[numberLine],
                (stepPointsHorizontal * numberLine) + stepPointsHorizontal / 2,
                listDrawPointPositionY[numberLine + 1],
                stepPointsHorizontal * (numberLine + 1),
                listDrawPointPositionY[numberLine + 1]
            )
        }
        canvas?.drawPath(linePath, paintLine)
        linePath.reset()
    }

    private fun drawVerticalLine(canvas: Canvas?) {
        canvas?.drawLine(
            partHorizontalAxis,
            0F,
            partHorizontalAxis,
            sizeVertical.toFloat(),
            paintAxis
        )
    }

    private fun drawHorizontalLine(canvas: Canvas?) {
        canvas?.drawLine(
            0F,
            partVerticalAxis,
            sizeHorizontal.toFloat(),
            partVerticalAxis,
            paintAxis
        )
    }

    private fun drawPoint(canvas: Canvas?, index: Int) {
        paintAxis.color = mainColor
        canvas?.drawCircle(
            stepPointsHorizontal * index,
            listDrawPointPositionY[index],
            radiusPoint,
            paintPoint
        )
    }

    private fun getVerticalPositionNewPoint(point: Float): Float {
        return if (point < 0)
            (abs(point) * partVerticalAxis) + partVerticalAxis
        else
            partVerticalAxis - (point * partVerticalAxis)
    }

    private fun updateUIGraph() {
        if (listDrawPointPositionY.isNotEmpty())
            getAnimator()
    }

    private fun getAnimator() {
        val newPointPositionY = listPointUser.map {
            getVerticalPositionNewPoint(it)
        }
        repeat(TOTAL_POINT) { pointY ->
            val animator = ValueAnimator()
            animator.apply {
                duration = 750
                interpolator = AccelerateDecelerateInterpolator()
                setFloatValues(listDrawPointPositionY[pointY], newPointPositionY[pointY])
                start()
                addUpdateListener { animation ->
                    val animatedValue = animation.animatedValue as Float
                    listDrawPointPositionY[pointY] = animatedValue
                    invalidate()
                }
            }
        }
    }

    private val myListener = object : GestureDetector.SimpleOnGestureListener() {
        override fun onDown(e: MotionEvent): Boolean {
            return true
        }
    }

    private val detector: GestureDetector = GestureDetector(context, myListener)

    private fun detectTouchPointLineY(x: Float, y: Float) {
        repeat(TOTAL_POINT) {
            val point = stepPointsHorizontal * it
            if (x < point + 80 && x > point - 80)
                listPointUser[it] = if (y > partVerticalAxis) {
                    (y - partVerticalAxis) / partVerticalAxis * -1
                } else
                    abs(partVerticalAxis - y) / partVerticalAxis
            getAnimator()
        }
    }

    fun getRandomPoint() {
        listPointUser = MutableList(TOTAL_POINT) { Random.nextFloat() * 2 - 1 }
    }

    companion object {
        private const val MIN_HEIGHT_VIEW_GRAPH = 500
        private const val TOTAL_POINT = 5
    }
}