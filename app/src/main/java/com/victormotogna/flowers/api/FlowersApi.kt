package com.victormotogna.flowers.api

import com.victormotogna.flowers.model.Order
import retrofit2.Call
import retrofit2.http.GET

interface FlowersApi {
    @GET("/getOrders")
    fun getFlowers(): Call<List<Order>>
}