package cc.fastcv.view.native

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import cc.fastcv.view.R
import cc.fastcv.view.adapter.ItemAdapter
import cc.fastcv.view.customize.bezierCurve.BezierCurveActivity
import cc.fastcv.view.customize.cornerFrameLayout.CornerFrameLayoutActivity
import cc.fastcv.view.customize.drawSpell.DrawSpellActivity
import cc.fastcv.view.customize.overlappingJudge.OverlappingJudgeActivity
import cc.fastcv.view.customize.pathFillType.PathFillTypeActivity
import cc.fastcv.view.customize.pathMeasure.PathMeasureActivity
import cc.fastcv.view.customize.radarView.RadarViewActivity
import cc.fastcv.view.customize.roundprogressbar.RoundProgressBarActivity
import cc.fastcv.view.customize.star.StarActivity
import cc.fastcv.view.customize.text.TextActivity
import cc.fastcv.view.customize.theoreticalBasis.TheoreticalBasisActivity
import cc.fastcv.view.customize.turntable.TurntableActivity
import cc.fastcv.view.customize.xfermode.XfermodeActivity
import cc.fastcv.view.native.marquee.MarqueeTextViewActivity

class NativeViewActivity : AppCompatActivity(), ItemAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_native)

        val rvComponent = findViewById<RecyclerView>(R.id.rv_component)
        rvComponent.adapter =
            ItemAdapter(resources.getStringArray(R.array.native_view_list).toMutableList(), this)
    }

    override fun onItemClick(position: Int) {
        when(position) {
            0 -> return
            1 -> startActivity(Intent(this, MarqueeTextViewActivity::class.java))
            else -> return
        }
    }

}