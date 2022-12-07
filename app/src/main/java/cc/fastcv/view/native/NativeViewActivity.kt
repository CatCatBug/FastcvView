package cc.fastcv.view.native

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import cc.fastcv.view.R
import cc.fastcv.view.adapter.ItemAdapter

class NativeViewActivity : AppCompatActivity(), ItemAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_native)

        val rvComponent = findViewById<RecyclerView>(R.id.rv_component)
        rvComponent.adapter =
            ItemAdapter(resources.getStringArray(R.array.native_view_list).toMutableList(), this)
    }

    override fun onItemClick(position: Int) {

    }

}