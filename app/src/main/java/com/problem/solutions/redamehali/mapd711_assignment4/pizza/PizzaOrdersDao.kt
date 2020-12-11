package com.problem.solutions.redamehali.mapd711_assignment4.pizza

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PizzaOrdersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPizza(pizza: Pizza)

    @Query("SELECT * FROM pizza_orders_table ORDER BY productId ASC")
    fun readPizzaOrdersData(): LiveData<List<Pizza>>
}
