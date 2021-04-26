package com.bsoft.weathercaseapp.ui.details

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bsoft.weathercaseapp.R
import com.bsoft.weathercaseapp.data.model.DayListItem
import com.bsoft.weathercaseapp.databinding.DayListItemBinding

class DayListAdapter (
    private val list: List<DayListItem>
) : RecyclerView.Adapter<DayListAdapter.DayListViewHolder>(){

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayListViewHolder =
        DayListViewHolder(
            DataBindingUtil.inflate<DayListItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.day_list_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: DayListViewHolder, position: Int) {
        holder.recyclerViewListItemBinding.listItem = list[position]

        when(list[position].weather_state_abbr) {
            "c" -> holder.recyclerViewListItemBinding.itemDayImage.setImageResource(R.drawable.c)
            "h" -> holder.recyclerViewListItemBinding.itemDayImage.setImageResource(R.drawable.h)
            "hc" -> holder.recyclerViewListItemBinding.itemDayImage.setImageResource(R.drawable.hc)
            "hr" -> holder.recyclerViewListItemBinding.itemDayImage.setImageResource(R.drawable.hr)
            "lc" -> holder.recyclerViewListItemBinding.itemDayImage.setImageResource(R.drawable.lc)
            "lr" -> holder.recyclerViewListItemBinding.itemDayImage.setImageResource(R.drawable.lr)
            "s" -> holder.recyclerViewListItemBinding.itemDayImage.setImageResource(R.drawable.s)
            "sl" -> holder.recyclerViewListItemBinding.itemDayImage.setImageResource(R.drawable.sl)
            "sn" -> holder.recyclerViewListItemBinding.itemDayImage.setImageResource(R.drawable.sn)
            "t" -> holder.recyclerViewListItemBinding.itemDayImage.setImageResource(R.drawable.t)

        }
    }

    inner class DayListViewHolder(
        val recyclerViewListItemBinding: DayListItemBinding
    ) : RecyclerView.ViewHolder(recyclerViewListItemBinding.root)
}