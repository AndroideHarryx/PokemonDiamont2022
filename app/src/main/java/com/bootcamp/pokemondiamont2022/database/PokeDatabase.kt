package com.bootcamp.pokemondiamont2022.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bootcamp.pokemondiamont2022.usuarios.Usuarios
import com.bootcamp.pokemondiamont2022.usuarios.UsuariosDAO
//creamos la base de datos
@Database(entities = [Usuarios::class], version = 1)
abstract class PokeDatabase : RoomDatabase(){
    abstract fun usuariosDAO(): UsuariosDAO
    companion object{
        private var INSTANCE: PokeDatabase? = null

        //creamos una funcion para instanciar la base de datos
        fun getInstance(context: Context): PokeDatabase?{
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, PokeDatabase::class.java, "database.db")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}