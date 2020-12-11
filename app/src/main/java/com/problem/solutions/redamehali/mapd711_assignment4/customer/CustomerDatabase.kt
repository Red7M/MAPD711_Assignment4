package com.problem.solutions.redamehali.mapd711_assignment4.customer

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by Reda Mehali on 12/3/20.
 */

@Database(entities = [Customer::class], version = 1, exportSchema = false)
abstract class CustomerDatabase: RoomDatabase() {

    abstract fun customerDao(): CustomerDao

    companion object {
        @Volatile
        private var INSTANCE : CustomerDatabase? = null

        fun getDatabase(context: Context): CustomerDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CustomerDatabase::class.java,
                    "customer_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}