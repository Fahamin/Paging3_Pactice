package kodi.tv.iptv.m3u.paging3_pactice.Paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kodi.tv.iptv.m3u.paging3_pactice.Model.Result
import kodi.tv.iptv.m3u.paging3_pactice.R

class QuotePageAdapter : PagingDataAdapter<Result, QuotePageAdapter.QuoteViewHolder>(COMPARATOR) {


    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.title_TV.text = item.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return QuoteViewHolder(view)
    }


    class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title_TV = itemView.findViewById<TextView>(R.id.title_TV)
    }


    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }
        }
    }


}