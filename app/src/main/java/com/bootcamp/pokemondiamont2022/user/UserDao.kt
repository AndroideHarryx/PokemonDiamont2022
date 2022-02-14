package com.bootcamp.pokemondiamont2022.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAll(): List<User>

    @Query("SELECT * FROM users WHERE name LIKE :username LIMIT 1")
    fun findUserByName(username: String): User

    @Query("SELECT * FROM users WHERE id LIKE :id")
    fun findUserById(id: String): User

    @Insert
    fun insertUser(vararg user: User)

    @Delete
    fun deleteUser(user: User)
}