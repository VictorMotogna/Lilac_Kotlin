package com.victormotogna.flowers.model

data class Order(
        val id: Int = 0,
        val description: String? = "",
        val price: Int = 0,
        val deliver_to: String? = "",
        val address: String? = ""
)