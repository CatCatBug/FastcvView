package cc.fastcv.view.customize.roundprogressbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cc.fastcv.view.R
import cc.fastcv.view.customize.roundprogressbar.custom.RoundProgressBar

class RoundProgressBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_round_progress_bar)

        findViewById<RoundProgressBar>(R.id.rpb).setOnClickListener {
            (it as RoundProgressBar).run()
        }
    }


}