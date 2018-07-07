package com.victormotogna.flowers.model

import java.io.Serializable

class Order
(
        var id: Int = 0,
        var description: String? = "",
        var price: Int = 0,
        var deliver_to: String? = "",
        var address: String? = ""
) : Serializable


/*
   Api model - JSON:
   {
       id: 1,
       description: "Red Roses",
       price: 50,
       deliver_to: "Bianca Rus",
       address: "str. Liviu Rebreanu 4, Cluj-Napoca"
    }
*/