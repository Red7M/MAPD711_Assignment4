package com.problem.solutions.redamehali.mapd711_assignment4.order

import androidx.lifecycle.LiveData

class OrderRepository(private val orderDao: OrdersDao) {

    val readAllOrdersData: LiveData<List<Order>> = orderDao.readOrdersData()

    suspend fun addOrder(order: Order) {
        orderDao.addOrder(order)
    }
}
