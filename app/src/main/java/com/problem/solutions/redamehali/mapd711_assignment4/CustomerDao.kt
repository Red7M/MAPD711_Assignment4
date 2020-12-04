package com.problem.solutions.redamehali.mapd711_assignment4

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by Reda Mehali on 12/3/20.
 */

@Dao
interface CustomerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCustomer(customer: Customer)

    @Query("SELECT * FROM customer_table ORDER BY customerId ASC")
    fun readCustomerData(): LiveData<List<Customer>>
}