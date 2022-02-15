package com.bootcamp.pokemondiamont2022.Datos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UsuarioDao {
    @Query("SELECT * FROM tabla_usuarios ORDER BY nombre ASC")
    fun getAllUsers():List<EntidadUsuario>

    @Query("SELECT * FROM tabla_usuarios WHERE id= :id")
    fun getById(id: Int?): EntidadUsuario

    @Query("SELECT * FROM tabla_usuarios WHERE nombre= :nombre")
    fun getByName(nombre: String?): EntidadUsuario

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertall(usuarios: List<EntidadUsuario>)

    @Insert
    fun insert(usuario: ArrayList<EntidadUsuario>)
}