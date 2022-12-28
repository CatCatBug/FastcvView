package cc.fastcv.view.customize.pathFillType

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.math.min

class PathFillTypeView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    private var mViewHeight = 0f
    private var mViewWidth = 0f

    private var mPath = Path()

    private var mPaint = Paint().apply {
        style = Paint.Style.FILL
        color = Color.RED
        isAntiAlias = true
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mViewHeight = h * 1.0f
        mViewWidth = w * 1.0f

        val point = PointF((mViewWidth / 2), (mViewHeight / 2))
        val rect = RectF(point.x - 300, point.y - 300, point.x, point.y)
        mPath.addRect(rect, Path.Direction.CCW)
        mPath.addCircle(point.x, point.y, 300f, Path.Direction.CCW)
        mPath.fillType = Path.FillType.EVEN_ODD

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawPath(mPath,mPaint)
    }

}