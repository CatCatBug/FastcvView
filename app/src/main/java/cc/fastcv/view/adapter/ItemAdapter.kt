package cc.fastcv.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import cc.fastcv.view.R

class ItemAdapter(private val data: List<String>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<ItemAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.tvTitle.text = data[position]
        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }

    override fun getItemCount() = data.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: AppCompatTextView = itemView.findViewById(R.id.tv_title)
    }
}