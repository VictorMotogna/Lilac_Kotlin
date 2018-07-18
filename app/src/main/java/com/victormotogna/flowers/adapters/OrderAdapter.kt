package com.victormotogna.flowers.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.victormotogna.flowers.R
import com.victormotogna.flowers.model.Order

class OrderAdapter(private var orderList: List<Order>) : RecyclerView.Adapter<OrderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_order, parent, false)

        return OrderViewHolder(itemView)
    }

    override fun getItemCount(): Int = orderList.size

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.updateUi(orderList[position])

        val myDescription = orderList[position].description

        holder.learnMore.setOnClickListener {
            Toast.makeText(holder.itemView.context, "$myDescription for ${orderList[position].deliver_to}", Toast.LENGTH_SHORT).show()
        }
    }

    fun updateList(newList: List<Order>) {
        this.orderList = newList
        notifyDataSetChanged()
    }

}