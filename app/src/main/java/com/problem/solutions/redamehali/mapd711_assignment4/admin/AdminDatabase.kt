package com.problem.solutions.redamehali.mapd711_assignment4.admin

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by Reda Mehali on 12/11/20.
 */
@Database(entities = [Admin::class], version = 1, exportSchema = false)
abstract class AdminDatabase: RoomDatabase() {

    abstract fun adminDao(): AdminDao

    companion object {
        @Volatile
        private var INSTANCE : AdminDatabase? = null

        fun getDatabase(context: Context): AdminDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AdminDatabase::class.java,
                    "admin_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}