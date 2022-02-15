package com.bootcamp.pokemondiamont2022.Datos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [EntidadUsuario::class], version = 1)
abstract class UsuarioDatabase: RoomDatabase() {
    abstract fun usuarioDao():UsuarioDao

    companion object{
        private var INSTANCE: UsuarioDatabase? = null

        fun getInstance(context: Context?): UsuarioDatabase?{
            if(INSTANCE == null){
                synchronized(UsuarioDatabase::class){
                    INSTANCE = context?.applicationContext?.let {
                        Room.databaseBuilder(
                            it,
                            UsuarioDatabase::class.java, "usuario.db").allowMainThreadQueries().build()
                    }
                }
            }
            return INSTANCE
        }
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}