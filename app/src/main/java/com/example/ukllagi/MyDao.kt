package com.example.ukllagi

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlin.collections.List

@Dao
interface MyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahData(data: MyData)

    @Query("SELECT * FROM MyData")
    fun ambilData(): LiveData<List<MyData>>
}