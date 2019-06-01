package me.moallemi.coinmarket.ui.browse

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.moallemi.coinmarket.R
import me.moallemi.coinmarket.domain.model.CurrencyInfo

class BrowseAdapter : RecyclerView.Adapter<BrowseAdapter.BrowseViewHolder>() {

    var items: List<CurrencyInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrowseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_currency_info_item, parent, false)
        return BrowseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BrowseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class BrowseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title = itemView.findViewById<TextView>(R.id.title)
        private val price = itemView.findViewById<TextView>(R.id.price)

        fun bind(item: CurrencyInfo) {
            title.text = item.name
            price.text = item.quote.uSD?.price.toString()
        }
    }
}