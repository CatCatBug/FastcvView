package cc.fastcv.view.customize

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import cc.fastcv.view.R
import cc.fastcv.view.adapter.ItemAdapter
import cc.fastcv.view.customize.bezierCurve.BezierCurveActivity
import cc.fastcv.view.customize.cornerFrameLayout.CornerFrameLayoutActivity
import cc.fastcv.view.customize.drawSpell.DrawSpellActivity
import cc.fastcv.view.customize.inscribedCircle.InscribedCircleActivity
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

class CustomViewActivity : AppCompatActivity(), ItemAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)


        val rvComponent = findViewById<RecyclerView>(R.id.rv_component)
        rvComponent.adapter = ItemAdapter(resources.getStringArray(R.array.custom_view_list).toMutableList(),this)
    }

    override fun onItemClick(position: Int) {
        when(position) {
            0 -> startActivity(Intent(this,TheoreticalBasisActivity::class.java))
            1 -> startActivity(Intent(this, PathFillTypeActivity::class.java))
            2 -> startActivity(Intent(this, OverlappingJudgeActivity::class.java))
            3 -> startActivity(Intent(this, DrawSpellActivity::class.java))
            4 -> startActivity(Intent(this, XfermodeActivity::class.java))
            5 -> startActivity(Intent(this, StarActivity::class.java))
            6 -> startActivity(Intent(this, TurntableActivity::class.java))
            7 -> startActivity(Intent(this, CornerFrameLayoutActivity::class.java))
            8 -> startActivity(Intent(this, RoundProgressBarActivity::class.java))
            9 -> startActivity(Intent(this, BezierCurveActivity::class.java))
            10 -> startActivity(Intent(this, RadarViewActivity::class.java))
            11 -> startActivity(Intent(this, PathMeasureActivity::class.java))
            12 -> startActivity(Intent(this, TextActivity::class.java))
            13 -> startActivity(Intent(this, InscribedCircleActivity::class.java))
            else -> return
        }
    }

}