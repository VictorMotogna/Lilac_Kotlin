package com.victormotogna.flowers

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.victormotogna.flowers.adapters.OrderAdapter
import com.victormotogna.flowers.api.ApiClient
import com.victormotogna.flowers.api.FlowersApi
import com.victormotogna.flowers.model.Order
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var jsonApi: FlowersApi
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init api
        val retrofit = ApiClient.instance
        jsonApi = retrofit.create(FlowersApi::class.java)

        // recycler view
        rv_all_orders.setHasFixedSize(true)
        rv_all_orders.layoutManager = LinearLayoutManager(this)
        fetchData()
    }

    private fun fetchData() {
        compositeDisposable.add(jsonApi.flowers
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { orders -> displayData(orders) })
    }

    private fun displayData(orders: List<Order>?) {
        val adapter = OrderAdapter(this, orders!!)
        rv_all_orders.adapter = adapter

        refresh_orders.setOnRefreshListener { fetchData() }
        adapter.notifyDataSetChanged()
        refresh_orders.isRefreshing = false
    }
}
