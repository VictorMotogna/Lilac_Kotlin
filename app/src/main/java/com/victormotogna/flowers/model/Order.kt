package com.victormotogna.flowers.model

import java.io.Serializable

data class Order(
        val id: Int = 0,
        val description: String? = "",
        val price: Int = 0,
        val deliver_to: String? = "",
        val address: String? = ""
) : Serializable


/*
   Api model - JSON:
   {
       id: 1,
       description: "Red Roses",
       price: 50,
       deliverTo: "Bianca Rus",
       address: "str. Liviu Rebreanu 4, Cluj-Napoca"
    }
*/