package com.victormotogna.flowers.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.victormotogna.flowers.R
import com.victormotogna.flowers.model.Order

class OrderAdapter(private var context: Context,
                   private var orderList: List<Order>) : RecyclerView.Adapter<OrderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_order, parent, false)

        return OrderViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    fun updateList(newList: List<Order>) {
        this.orderList = newList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.updateUi(orderList[position])

        holder.learnMore.setOnClickListener {
            Toast.makeText(context, "${orderList[position].description} for ${orderList[position].deliver_to}", Toast.LENGTH_SHORT).show()
        }
    }

}