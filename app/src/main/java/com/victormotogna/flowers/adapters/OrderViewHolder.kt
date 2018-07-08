package com.victormotogna.flowers.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_order.view.*

class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val description = itemView.description
    val price = itemView.price
    val address = itemView.address
    val deliver_to = itemView.deliver_to
    val learn_more = itemView.learn_more
}