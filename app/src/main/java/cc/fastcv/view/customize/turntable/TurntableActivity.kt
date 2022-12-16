package cc.fastcv.view.customize.turntable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cc.fastcv.view.R
import cc.fastcv.view.customize.turntable.custom.TurntableView

class TurntableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_turntable)

        findViewById<TurntableView>(R.id.tbv).setOnClickListener {
//            (it as TurntableView).run()
        }
    }

}