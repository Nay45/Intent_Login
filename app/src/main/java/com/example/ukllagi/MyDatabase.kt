package com.example.ukllagi

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MyData::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun myDao(): MyDao
    companion object {
        var INSTANCE: MyDatabase? = null
        fun getMyDatabase(context: Context): MyDatabase? {
            if (INSTANCE == null) {
                synchronized(MyDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, MyDatabase::class.java, "ShoeStore").build()
                }
            }
            return INSTANCE
        }
        fun destroyBase() {
            INSTANCE = null
        }
    }
}