package com.problem.solutions.redamehali.mapd711_assignment4.admin

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Reda Mehali on 12/11/20.
 */
@Entity(tableName = "admin_table")
data class Admin (
    @PrimaryKey(autoGenerate = true)
    val employeeId: Int,
    val username: String,
    val password: String,
    val firstName: String,
    val lastName: String
)