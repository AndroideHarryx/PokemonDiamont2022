package com.bootcamp.pokemondiamont2022.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bootcamp.pokemondiamont2022.user.User
import com.bootcamp.pokemondiamont2022.user.UserDao

@Database(entities = [User::class], version = 1)
abstract class PokedexDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    companion object {
        private var INSTANCE: PokedexDatabase? = null

        fun getInstance(context: Context): PokedexDatabase? {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, PokedexDatabase::class.java, "database.db")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}