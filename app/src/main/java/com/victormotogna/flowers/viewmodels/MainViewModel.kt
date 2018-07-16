package com.victormotogna.flowers.viewmodels

import android.arch.lifecycle.ViewModel
import com.victormotogna.flowers.api.ApiClient
import com.victormotogna.flowers.api.FlowersApi
import com.victormotogna.flowers.model.Order
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.koin.standalone.KoinComponent
import java.util.*

class MainViewModel : ViewModel(), KoinComponent {
    private lateinit var jsonApi: FlowersApi
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    var orderList: List<Order> = ArrayList()

    fun fetchData(): List<Order> {
        // init api
        val retrofit = ApiClient.instance
        jsonApi = retrofit.create(FlowersApi::class.java)

        compositeDisposable.add(jsonApi.flowers
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { orderList })

        return orderList
    }
}