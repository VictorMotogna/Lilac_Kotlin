package com.victormotogna.flowers.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.victormotogna.flowers.R
import com.victormotogna.flowers.model.Order

class OrderAdapter(internal var context: Context, internal var orderList: List<Order>) : RecyclerView.Adapter<OrderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_order, parent, false)

        return OrderViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.description.text = orderList.get(position).description
        holder.price.text = orderList.get(position).price.toString()
        holder.address.text = orderList.get(position).address
        holder.deliver_to.text = orderList.get(position).deliver_to
    }

}