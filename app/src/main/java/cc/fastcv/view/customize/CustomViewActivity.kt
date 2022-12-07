package cc.fastcv.view.customize

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import cc.fastcv.view.R
import cc.fastcv.view.adapter.ItemAdapter
import cc.fastcv.view.customize.theoreticalBasis.TheoreticalBasisActivity

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
            else -> return
        }
    }

}