package com.bootcamp.pokemondiamont2022.database

import androidx.room.*

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User)

    @Query("SELECT * FROM users")
    fun gelAllUsers(): List<User>

    @Query("SELECT * FROM users WHERE userName = :username LIMIT 1")
    fun getUserByUsername(username: String): User

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)
}