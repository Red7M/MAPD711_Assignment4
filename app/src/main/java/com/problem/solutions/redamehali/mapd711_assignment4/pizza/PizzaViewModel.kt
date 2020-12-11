package com.problem.solutions.redamehali.mapd711_assignment4.pizza

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PizzaViewModel(application: Application) : AndroidViewModel(application)  {

    val readAllPizzaOrdersData: LiveData<List<Pizza>>
    private val repository: PizzaOrderRepository

    init {
        val pizzaOrderDao = PizzaOrdersDatabase.getDatabase(application).pizzaOrdersDao()
        repository = PizzaOrderRepository(pizzaOrderDao)
        readAllPizzaOrdersData = repository.readAllPizzaOrdersData
    }

    fun addPizza(pizza: Pizza) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPizza(pizza)
        }
    }
}
