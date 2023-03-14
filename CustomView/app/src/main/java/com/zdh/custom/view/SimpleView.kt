package com.zdh.custom.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import java.security.AccessControlContext

class SimpleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var currentWidth = 0


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawCircle(canvas)

        drawRect(canvas)

        drawPoint(canvas)

        drawLine(canvas)

        drawOval(canvas)

        drawRoundRect(canvas)

        drawArc(canvas)

        drawPath(canvas)
    }

    private fun drawPath(canvas: Canvas) {

        // 1. 画空❤️
        val path = Path()
        path.addArc(RectF(30f, 820f, 30 + 100f, 920f), 140f, 220f) // 添加弧形
        path.arcTo(RectF(30f + 100f, 820f, 130f + 100, 920f), 180f, 220f, false)// 添加第二个弧形
        path.lineTo((130f + 100 + 30) / 2, 920f + 100f) // 添加直线
        path.close() // 闭合

        paint.color = Color.BLACK
        canvas.drawPath(path, paint)

        // 2. 画实❤️
        val path2 = Path()
        path2.addArc(RectF(330f, 820f, 330f + 100f, 920f), 140f, 220f) // 添加弧形
        // @param forceMoveTo: 直线连接到弧形处显示痕迹
        path2.arcTo(RectF(330f + 100f, 820f, 430f + 100, 920f), 180f, 220f, false)// 添加第二个弧形
        path2.lineTo((430f + 100 + 330f) / 2, 920f + 100f) // 添加线
        path2.close() // 闭合

        paint.color = Color.RED
        paint.style = Paint.Style.FILL
        canvas.drawPath(path2, paint)

        // Path.Direction.CCW: clockwise 顺时针
        // Path.Direction.CW: counter-clockwise: 逆时针
        // 3. 画圆
        val path3 = Path()
        path3.addCircle(120f, 1150f, 100f, Path.Direction.CCW)
        path3.addCircle(120f + 100f, 1150f, 100f, Path.Direction.CCW)
        paint.style = Paint.Style.STROKE // 空心
        canvas.drawPath(path3, paint)


        // 4. 画圆
        val path4 = Path()
        path4.addCircle(450f, 1150f, 100f, Path.Direction.CW)
        path4.addCircle(450f + 100f, 1150f, 100f, Path.Direction.CW)
        paint.style = Paint.Style.FILL // 实心
        canvas.drawPath(path4, paint)


        // 5. 画圆
        val path5 = Path()
        path5.addCircle(780f, 1150f, 100f, Path.Direction.CCW)
        path5.addCircle(780f + 100f, 1150f, 100f, Path.Direction.CW)
        paint.style = Paint.Style.FILL
//        EVEN_ODD [交叉填充]
//        WINDING [全填充]（默认值）
//        INVERSE_EVEN_ODD
//        INVERSE_WINDING
        path.fillType = Path.FillType.EVEN_ODD
        canvas.drawPath(path5, paint)

        // 6. 画线
        val path6 = Path()
        path6.moveTo(50f, 1320f)
        path6.lineTo(90f, 1340f)
        path6.lineTo(140f, 1290f)
        paint.style = Paint.Style.STROKE
        canvas.drawPath(path6, paint)


        // 7. 画线
        val path7 = Path()
        path7.moveTo(150f, 1320f)
        path7.lineTo(350f, 1320f)
        path7.arcTo(RectF(250f, 1350f, 350f, 1450f), 0f, 350f, false) // forceMoveTo 连接点有痕迹
        paint.style = Paint.Style.STROKE
        canvas.drawPath(path7, paint)
    }

    private fun drawArc(canvas: Canvas) {

        // 1.
        paint.color = Color.RED
        canvas.drawRect(RectF(20f, 700f, 100 + 20f, 800f), paint)

        paint.color = Color.GREEN
        canvas.drawArc(20f, 700f, 100f + 20f, 800f, 0f, 90f, true, paint)

        // 2.
        paint.color = Color.RED
        canvas.drawRect(RectF(150f, 700f, 150f + 100f, 800f), paint)

        paint.color = Color.GREEN
        paint.style = Paint.Style.STROKE // 空心模式
        canvas.drawArc(150f, 700f, 150f + 100f, 800f, 0f, 180f, false, paint)

        // 3.
        paint.color = Color.RED
        canvas.drawRect(RectF(150f + 100f + 20f, 700f, 270f + 100f, 800f), paint)

        paint.color = Color.GREEN
        paint.style = Paint.Style.STROKE // 空心模式
        canvas.drawArc(270f, 700f, 270f + 100f, 800f, 0f, 180f, true, paint)
    }

    private fun drawOval(canvas: Canvas) {
        // 1.
        canvas.drawOval(10f, 350f, currentWidth / 4f, 420f, paint)

        // 2.
        paint.style = Paint.Style.STROKE // 空心椭圆
        canvas.drawOval(currentWidth / 4 + 10f, 350f, currentWidth / 4 * 2f, 420f, paint)

        // 3.
        paint.color = Color.GREEN
        paint.strokeWidth = 2f
        canvas.drawOval(RectF(currentWidth / 4 * 2 + 20f, 350f, currentWidth / 4 * 3f, 420f),
            paint)
    }

    @SuppressLint("Range")
    private fun drawLine(canvas: Canvas) {
        // 1.
        paint.strokeWidth = 6f
        paint.color = Color.RED
        canvas.drawLine(30f, 460f, currentWidth / 2f - 30f, 500f, paint)
        canvas.drawLine(30f, 500f, currentWidth / 2f - 30f, 460f, paint)

        // 2. 绘制多条线
        var i = 0
        val floats = floatArrayOf(
            currentWidth / 2f + i * 30, // startX,
            460f, // endX
            currentWidth / 2f + i * 30, // endX
            520f,    // endY

            currentWidth / 2f + ++i * 30,
            460f,
            currentWidth / 2f + i * 30,
            520f,

            currentWidth / 2f + ++i * 30,
            460f,
            currentWidth / 2f + i * 30,
            520f,

            currentWidth / 2f + ++i * 30,
            460f,
            currentWidth / 2f + i * 30,
            520f
        )
        paint.color = Color.GREEN
        canvas.drawLines(floats, paint)

    }

    private fun drawRoundRect(canvas: Canvas) {
        // 1.
        paint.color = Color.RED
        canvas.drawRoundRect(20f, 550F, currentWidth / 3f, 550f + 100f, 40f, 40f, paint)

        // 2.
        paint.color = Color.RED
        paint.style = Paint.Style.FILL
        canvas.drawRoundRect(currentWidth / 3f + 20f,
            550F,
            currentWidth / 3f * 2,
            550f + 100f,
            40f,
            40f,
            paint)

    }

    @SuppressLint("Range")
    private fun drawPoint(canvas: Canvas) {
        // 1.
        paint.color = Color.RED
        paint.strokeCap = Paint.Cap.SQUARE // 小正方形 (默认)
        canvas.drawPoint(20f, 300f, paint)

        // 2.
        paint.color = Color.BLACK
        paint.strokeCap = Paint.Cap.ROUND // 小圆点
        canvas.drawPoint(20 * 2f, 300f, paint)

        var i = 2
        // 3.设置多个点
        paint.color = Color.GREEN
        val floats = floatArrayOf(
            20f * ++i, 300f, // x1 ,y1
            20f * ++i, 300f, // x2 ,y2
            20f * ++i, 300f, // x3 ,y3
            20f * ++i, 300f, // x4 ,y4
            20f * ++i, 300f, // x5 ,y5
        )
        canvas.drawPoints(floats, paint)


        paint.color = Color.RED
        val floats2 = floatArrayOf(
            20f * ++i, 300f, // x1 ,y1
            20f * ++i, 300f, // x2 ,y2
            20f * ++i, 300f, // x3 ,y3
            20f * ++i, 300f, // x4 ,y4
            20f * ++i, 300f, // x5 ,y5
            20f * ++i, 300f, // x6 ,y6
            20f * ++i, 300f, // x7 ,y7
            20f * ++i, 300f, // x8 ,y8
            20f * ++i, 300f, // x9 ,y9
            20f * ++i, 300f, // x10 ,y10
        )

        canvas.drawPoints(floats2, 4, 14, paint)
    }

    private fun drawRect(canvas: Canvas) {
        paint.style = Paint.Style.STROKE // 空心样式
        paint.strokeWidth = 10f // 设置线条宽度
        canvas.drawRect(10f, 150f, currentWidth / 8f, 150f + 100f, paint)

        paint.style = Paint.Style.FILL // 实心样式
        canvas.drawRect(currentWidth / 8 + 10f,
            150f,
            currentWidth / 8 * 2f,
            150f + 100f,
            this.paint)

        paint.color = Color.BLACK
        canvas.drawRect(
            Rect(currentWidth / 8 * 2 + 10, 150, currentWidth / 8 * 3, 150 + 100),
            paint)

        paint.color = Color.GREEN
        canvas.drawRect(
            RectF(currentWidth / 8 * 3 + 10f, 150f, currentWidth / 8 * 4f, 150 + 100f),
            paint)

    }

    private fun drawCircle(canvas: Canvas?) {

        paint.style = Paint.Style.STROKE
        canvas?.drawCircle(60f,60f,50f,paint)

        paint.style = Paint.Style.FILL // 填充样式
        canvas?.drawCircle(180f, 60f, 50f, paint)

        paint.style = Paint.Style.FILL_AND_STROKE // 即填充 又 铺满
        canvas?.drawCircle(300f, 60f, 50f, paint)

        paint.style = Paint.Style.STROKE // 空心样式
        paint.strokeWidth = 15f // 设置线条宽度
        canvas?.drawCircle(480f, 60f, 50f, paint)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        currentWidth = w
    }


    private val paint by lazy {

        Paint().also {
            it.color = Color.BLUE
            it.style = Paint.Style.FILL
            it.strokeWidth = 3f
            it.isAntiAlias = true
        }
    }

}