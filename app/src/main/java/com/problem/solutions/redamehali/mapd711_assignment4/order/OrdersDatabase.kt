package com.problem.solutions.redamehali.mapd711_assignment4.order

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Order::class], version = 1, exportSchema = false)
abstract class OrdersDatabase: RoomDatabase() {

    abstract fun ordersDao(): OrdersDao

    companion object {
        @Volatile
        private var INSTANCE : OrdersDatabase? = null

        fun getDatabase(context: Context): OrdersDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    OrdersDatabase::class.java,
                    "order_table"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}