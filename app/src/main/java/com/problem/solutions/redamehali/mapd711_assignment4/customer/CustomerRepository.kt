package com.problem.solutions.redamehali.mapd711_assignment4.customer

import androidx.lifecycle.LiveData

/**
 * Created by Reda Mehali on 12/3/20.
 */
class CustomerRepository(private val customerDao: CustomerDao) {

    val readAllCustomerData: LiveData<List<Customer>> = customerDao.readCustomerData()

    suspend fun addCustomer(customer: Customer) {
        customerDao.addCustomer(customer)
    }

}