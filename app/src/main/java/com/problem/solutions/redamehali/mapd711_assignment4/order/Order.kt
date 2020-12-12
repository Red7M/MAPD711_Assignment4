package com.problem.solutions.redamehali.mapd711_assignment4.order

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Reda Mehali on 12/11/20.
 */
@Entity(tableName = "order_table")
data class Order(
    @PrimaryKey(autoGenerate = true)
    val orderId: Int,
    val productId: Int,
    val quantity: String,
    val orderDate: String,
    val customer: String,
    val status: String)

