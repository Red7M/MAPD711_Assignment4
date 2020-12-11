package com.problem.solutions.redamehali.mapd711_assignment4.pizza

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Pizza::class], version = 1, exportSchema = false)
abstract class PizzaOrdersDatabase: RoomDatabase() {

    abstract fun pizzaOrdersDao(): PizzaOrdersDao

    companion object {
        @Volatile
        private var INSTANCE : PizzaOrdersDatabase? = null

        fun getDatabase(context: Context): PizzaOrdersDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PizzaOrdersDatabase::class.java,
                    "pizza_orders_table"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}
