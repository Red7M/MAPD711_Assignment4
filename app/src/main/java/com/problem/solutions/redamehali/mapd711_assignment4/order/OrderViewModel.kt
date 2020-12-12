package com.problem.solutions.redamehali.mapd711_assignment4.order

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Reda Mehali on 12/11/20.
 */
class OrderViewModel (application: Application) : AndroidViewModel(application)  {

    val readAllOrders: LiveData<List<Order>>
    private val repository: OrderRepository

    init {
        val orderDao = OrdersDatabase.getDatabase(application).ordersDao()
        repository = OrderRepository(orderDao)
        readAllOrders = repository.readAllOrdersData
    }

    fun addOrder(order: Order) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addOrder(order)
        }
    }
}