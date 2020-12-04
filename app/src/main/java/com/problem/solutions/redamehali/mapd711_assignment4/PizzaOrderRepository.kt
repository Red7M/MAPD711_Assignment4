package com.problem.solutions.redamehali.mapd711_assignment4

import androidx.lifecycle.LiveData

class PizzaOrderRepository(private val pizzaOrderDao: PizzaOrdersDao) {

    val readAllPizzaOrdersData: LiveData<List<Pizza>> = pizzaOrderDao.readPizzaOrdersData()

    suspend fun addPizza(pizza: Pizza) {
        pizzaOrderDao.addPizza(pizza)
    }
}
