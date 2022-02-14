package com.bootcamp.pokemondiamont2022.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User (
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val username: String?,
    @ColumnInfo(name = "user_password") val password: String?
)