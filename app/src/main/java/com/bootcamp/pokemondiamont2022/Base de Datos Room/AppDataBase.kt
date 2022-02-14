package com.bootcamp.pokemondiamont2022.BasedeDatosRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Usuarios::class],
    version = 1
)

abstract class AppDataBase : RoomDatabase() {
    abstract fun usuariosDao(): UsuariosDao

    companion object {
        private var INSTANCE: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase? {
            if (INSTANCE == null) {
                synchronized(AppDataBase::class) {
                    INSTANCE =
                        Room.databaseBuilder(context.applicationContext,
                            AppDataBase::class.java,
                            "usuario.db").allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
    }
}