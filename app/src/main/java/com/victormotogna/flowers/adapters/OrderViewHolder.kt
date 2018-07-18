package com.victormotogna.flowers.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.victormotogna.flowers.model.Order
import kotlinx.android.synthetic.main.item_order.view.*


class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val description: TextView = itemView.description
    val price: TextView = itemView.price
    val address: TextView = itemView.address
    val deliverTo: TextView = itemView.deliver_to
    val learnMore: Button = itemView.learn_more

    fun updateUi(order: Order) {
        description.text = order.description
        price.text = order.price.toString()
        address.text = order.address
        deliverTo.text = order.deliver_to
    }
}