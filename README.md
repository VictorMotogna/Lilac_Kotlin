# Lilac - Android flower ordering app
# Kotlin Adaptation

## Description

**Lilac** is an Android application used to manage incoming flower orders. It can help online sellers to view data about their orders, on the go.

Each order would have information about: the id of the order, description of the flowers, total price of the order, client name & his address.

## Technologies used: **Kotlin** https://kotlinlang.org/

### HTTP Requests
  http://demo9997383.mockable.io/getOrders - HTTP request URL
  
  Request Body:
  ```
  {
    "id": 20,
    "description": "Red Roses",
    "price": 50,
    "deliver_to": "Bianca",
    "address": "str. Liviu Rebreanu 4, Cluj-Napoca"
  }
  ```


  #### Retrofit 2.3 - http://square.github.io/retrofit/
  
  ## Java application: https://github.com/VictorMotogna/Lilac
