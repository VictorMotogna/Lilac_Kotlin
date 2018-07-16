package com.victormotogna.flowers

import android.arch.lifecycle.Observer
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
    private val adapter by lazy { OrderAdapter(this, listOf()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUi()
//        refresh_orders.isRefreshing = true
//        viewModel.fetchData()
        observeModel()
    }

    private fun setupUi() {
        rv_all_orders.setHasFixedSize(true)
        rv_all_orders.layoutManager = LinearLayoutManager(this)
        rv_all_orders.adapter = adapter

        refresh_orders.setOnRefreshListener { viewModel.fetchData() }
    }

    private fun observeModel() {
        viewModel.orderList.observe(this, Observer<List<Order>> { listOfFlowers ->
            adapter.updateList(listOfFlowers ?: listOf())
            refresh_orders.isRefreshing = false
        })
    }
}
