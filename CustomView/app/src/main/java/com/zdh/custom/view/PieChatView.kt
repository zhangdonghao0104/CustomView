package com.zdh.custom.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import kotlin.math.cos
import kotlin.math.sin

class PieChatView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
) : View(context, attrs, defStyleAttr) {

    // 初始化数据
    private val data = arrayListOf(
        Pair(30f, Color.RED), // first = 占比率; second = 颜色;
        Pair(130f, Color.BLACK),
        Pair(40f, Color.YELLOW),
        Pair(80f, Color.MAGENTA),
        Pair(80f, Color.GREEN),
    )
    private val paint = Paint()

    companion object {
        // 饼状图半径
        private val RADIUS = 100f
        // 选中
        private const val SELECT = 4
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        var temp = 0f
        data.forEachIndexed { index, pair ->
            paint.color = pair.second


            if (index == SELECT) {
                canvas.save()
                val dx = 50 * (cos(Math.toRadians((pair.first / 2 + temp).toDouble())).toFloat())
                val dy = 50 * (sin(Math.toRadians((pair.first / 2 + temp).toDouble())).toFloat())
                canvas.translate(
                    dx,
                    dy,
                )

                Log.i("szj占比", "dx = $dx\tdy:$dy")
            }
            canvas.drawArc(
                width / 2f - RADIUS, height / 2f - RADIUS,
                width / 2f + RADIUS, height / 2f + RADIUS,
                temp,
                pair.first,
                true, // 是否居中绘制
                paint
            )
            temp += pair.first

            if (index == SELECT) {
                canvas.restore()
            }
        }
    }
}