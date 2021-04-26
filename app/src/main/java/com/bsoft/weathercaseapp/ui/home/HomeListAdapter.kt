package com.bsoft.weathercaseapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.bsoft.weathercaseapp.R
import com.bsoft.weathercaseapp.data.model.HomeListItem
import com.bsoft.weathercaseapp.databinding.HomeListItemBinding


class HomeListAdapter (
    private val list: List<HomeListItem>
) : RecyclerView.Adapter<HomeListAdapter.HomeListViewHolder>(){

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder =
        HomeListViewHolder(
            DataBindingUtil.inflate<HomeListItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.home_list_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        holder.recyclerViewListItemBinding.listItem = list[position]

        holder.recyclerViewListItemBinding.itemHomeLayout.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment2(list[position].woeid.toString())
            findNavController(holder.itemView).navigate(action)
        }


    }

    inner class HomeListViewHolder(
        val recyclerViewListItemBinding: HomeListItemBinding
    ) : RecyclerView.ViewHolder(recyclerViewListItemBinding.root)
}