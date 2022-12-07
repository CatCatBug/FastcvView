package cc.fastcv.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import cc.fastcv.view.customize.CustomViewActivity
import cc.fastcv.view.native.NativeViewActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<AppCompatButton>(R.id.bt_into_customize).setOnClickListener {
            startActivity(Intent(this,CustomViewActivity::class.java))
        }

        findViewById<AppCompatButton>(R.id.bt_into_native).setOnClickListener {
            startActivity(Intent(this,NativeViewActivity::class.java))
        }
    }
}