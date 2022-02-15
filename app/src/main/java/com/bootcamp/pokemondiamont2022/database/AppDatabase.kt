package com.bootcamp.pokemondiamont2022.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [User::class], exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            var instance = INSTANCE
            if (INSTANCE == null) {
                synchronized (AppDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java, "pokedb")
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return INSTANCE;
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}