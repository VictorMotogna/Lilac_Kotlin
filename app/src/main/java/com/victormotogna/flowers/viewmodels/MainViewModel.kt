package com.victormotogna.flowers.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.victormotogna.flowers.api.FlowersApi
import com.victormotogna.flowers.model.Order
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel(), KoinComponent {
    private val jsonApi by inject<FlowersApi>()
    val orderList: MutableLiveData<List<Order>> = MutableLiveData()

    fun fetchData() {

        jsonApi.getFlowersFunc().enqueue(object : Callback<List<Order>> {
            override fun onFailure(call: Call<List<Order>>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<List<Order>>?, response: Response<List<Order>>?) {
                Log.d("TESTSS", "body: ${response?.body()}")
                orderList.value = response?.body() ?: return
            }
        })
    }
}