package com.problem.solutions.redamehali.mapd711_assignment4

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Reda Mehali on 12/3/20.
 */
@Entity(tableName = "pizza_orders_table")
data class Pizza(
    @PrimaryKey(autoGenerate = true)
    val productId: Int,
    val pizzaName: String,
    val customer: String,
    val quantity: String)