package com.problem.solutions.redamehali.mapd711_assignment4

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Reda Mehali on 12/3/20.
 */
@Entity(tableName = "customer_table")
data class Customer(
    @PrimaryKey(autoGenerate = true)
    val customerId: Int,
    val username: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val address: String,
    val city: String,
    val postalCode: String
)