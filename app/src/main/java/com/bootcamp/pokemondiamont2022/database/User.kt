package com.bootcamp.pokemondiamont2022.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "users")
data class User (

    @PrimaryKey(autoGenerate = true)
    var userId: Int? = null,

    val username: String,
    val dob: String, // Fecha de nacimiento, date of birth
    val email: String?,
    val password: String
)