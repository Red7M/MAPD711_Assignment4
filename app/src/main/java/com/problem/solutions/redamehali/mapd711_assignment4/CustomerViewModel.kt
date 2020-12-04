package com.problem.solutions.redamehali.mapd711_assignment4

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Reda Mehali on 12/3/20.
 */
class CustomerViewModel(application: Application) : AndroidViewModel(application) {

    val readAllCustomerData: LiveData<List<Customer>>
    private val repository: CustomerRepository

    init {
        val customerDao = CustomerDatabase.getDatabase(application).customerDao()
        repository = CustomerRepository(customerDao)
        readAllCustomerData = repository.readAllCustomerData
    }

    fun addCustomer(customer: Customer) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCustomer(customer)
        }
    }
}