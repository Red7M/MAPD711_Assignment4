package com.problem.solutions.redamehali.mapd711_assignment4.admin

import androidx.lifecycle.LiveData

class AdminRepository(private val adminDao: AdminDao) {

    val readAllAdminData: LiveData<List<Admin>> = adminDao.readAdminData()

    suspend fun addAdmin(admin: Admin) {
        adminDao.addAdmin(admin)
    }
}
