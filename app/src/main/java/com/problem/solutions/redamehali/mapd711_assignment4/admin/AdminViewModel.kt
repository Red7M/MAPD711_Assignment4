package com.problem.solutions.redamehali.mapd711_assignment4.admin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.problem.solutions.redamehali.mapd711_assignment4.customer.Customer
import com.problem.solutions.redamehali.mapd711_assignment4.customer.CustomerDatabase
import com.problem.solutions.redamehali.mapd711_assignment4.customer.CustomerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Reda Mehali on 12/11/20.
 */
class AdminViewModel (application: Application) : AndroidViewModel(application) {

    val readAllAdminData: LiveData<List<Admin>>
    private val repository: AdminRepository

    init {
        val adminDao = AdminDatabase.getDatabase(application).adminDao()
        repository = AdminRepository(adminDao)
        readAllAdminData = repository.readAllAdminData
    }

    fun addAdmin(admin: Admin) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addAdmin(admin)
        }
    }
}