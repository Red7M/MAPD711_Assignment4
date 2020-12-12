package com.problem.solutions.redamehali.mapd711_assignment4.order

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface OrdersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addOrder(order: Order)

    @Query("SELECT * FROM order_table ORDER BY orderId ASC")
    fun readOrdersData(): LiveData<List<Order>>
}
