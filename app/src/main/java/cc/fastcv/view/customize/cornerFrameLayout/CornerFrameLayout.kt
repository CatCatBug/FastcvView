package cc.fastcv.view.customize.cornerFrameLayout

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.widget.FrameLayout

class CornerFrameLayout : FrameLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    private var mBgDrawable:Drawable? = null

    private val mRoundRect = RectF(0f, 0f, 0f, 0f)

    private val mPath = Path()

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mRoundRect.right = w * 1.0f
        mRoundRect.bottom = h * 1.0f
        Log.d("xcl_debug", "onSizeChanged: mRoundRect = $mRoundRect")
        mPath.addRoundRect(
            mRoundRect,
            floatArrayOf(100f, 100f, 100f, 100f, 100f, 100f, 100f, 100f), Path.Direction.CW
        )
    }

    override fun dispatchDraw(canvas: Canvas) {
        canvas.clipPath(mPath)
        super.dispatchDraw(canvas)
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.let {
            it.clipPath(mPath)
            mBgDrawable?.draw(it)
        }
    }

    override fun setBackground(background: Drawable?) {
        mBgDrawable = background?.mutate()
    }

}