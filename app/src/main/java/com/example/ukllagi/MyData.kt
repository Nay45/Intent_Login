package com.example.ukllagi

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class MyData(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val nama: String,
    val email: String,
    val date: String
)
