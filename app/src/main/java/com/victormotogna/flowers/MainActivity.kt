package com.victormotogna.flowers

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.victormotogna.flowers.adapters.OrderAdapter
import com.victormotogna.flowers.model.Order
import com.victormotogna.flowers.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val viewModel by inject<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // recycler view
        rv_all_orders.setHasFixedSize(true)
        rv_all_orders.layoutManager = LinearLayoutManager(this)
        fetchData()
    }

    private fun fetchData() {
        displayData(viewModel.fetchData())
    }

    private fun displayData(orders: List<Order>?) {
        val adapter = OrderAdapter(this, orders!!)
        rv_all_orders.adapter = adapter

        refresh_orders.setOnRefreshListener { fetchData() }
        adapter.notifyDataSetChanged()
        refresh_orders.isRefreshing = false
    }
}
