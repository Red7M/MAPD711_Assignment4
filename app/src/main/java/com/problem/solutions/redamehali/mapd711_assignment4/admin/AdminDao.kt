package com.problem.solutions.redamehali.mapd711_assignment4.admin

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by Reda Mehali on 12/11/20.
 */
@Dao
interface AdminDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAdmin(admin: Admin)

    @Query("SELECT * FROM admin_table ORDER BY employeeId ASC")
    fun readAdminData(): LiveData<List<Admin>>
}