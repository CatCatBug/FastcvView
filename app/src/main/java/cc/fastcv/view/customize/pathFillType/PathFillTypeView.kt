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

    //绘制缓冲，避免击穿整个 window 的画布出现黑色背景的情况
    private var mBitmap: Bitmap? = null
    private val mCanvas = Canvas()
    private val mMatrix = Matrix()

    private var mPaint = Paint().apply {
        style = Paint.Style.FILL
        alpha = 0
        isAntiAlias = true
        xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mViewHeight = h*1.0f
        mViewWidth = w*1.0f
        mPath.moveTo(0f,0f)
        mPath.addCircle(0f,0f, min(mViewHeight,mViewWidth)/2 - 10,Path.Direction.CW)
        mPath.fillType = Path.FillType.INVERSE_EVEN_ODD

        if (mBitmap == null || mBitmap!!.width != w || mBitmap!!.height != h) {
            mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)

            mCanvas.setBitmap(mBitmap)
        }
    }

    override fun draw(canvas: Canvas) {
        mBitmap!!.eraseColor(Color.TRANSPARENT)
        super.draw(mCanvas)
        mCanvas.save()
        mCanvas.translate(mViewWidth/2,mViewHeight/2)
        mCanvas.drawPath(mPath, mPaint)
        mCanvas.restore()
        canvas.drawBitmap(mBitmap!!, mMatrix, null)

//        mBitmap!!.eraseColor(Color.TRANSPARENT)
//        super.draw(mCanvas)
//        mCanvas.drawPath(mPath, mPaint)
//        canvas.drawBitmap(mBitmap!!, mMatrix, null)
    }

//    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
//        val saved = canvas!!.saveLayer(null, null)
//        canvas.translate(mViewWidth/2,mViewHeight/2)
//        canvas.drawPath(mPath,mPaint)
//        canvas.restoreToCount(saved)
//        mBitmap!!.eraseColor(Color.TRANSPARENT)
//        super.onDraw(mCanvas)
//        mCanvas.drawPath(mPath, mPaint)
//        canvas?.drawBitmap(mBitmap!!, mMatrix, null)

//        canvas!!.save()
//        canvas.translate(mViewWidth/2,mViewHeight/2)
//        canvas.drawPath(mPath,mPaint)
//        canvas.restore()
//    }


}