package com.victormotogna.flowers.api

import com.victormotogna.flowers.model.Order
import io.reactivex.Observable
import retrofit2.http.GET

interface FlowersApi {
    @get: GET("getOrders")
    val flowers: Observable<List<Order>>
}