package com.bootcamp.pokemondiamont2022.usuarios

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuariosDAO {

    @Query("SELECT * FROM usuarios")
    fun getAll(): List<Usuarios>

    @Query("SELECT * FROM usuarios WHERE nombre LIKE :username LIMIT 1")
    fun findUsuariosByName(username: String): Usuarios

    @Query("SELECT * FROM usuarios WHERE id LIKE :id")
    fun findUsuariosById(id: String): Usuarios

    @Insert
    fun insertUsuarios(vararg Usuarios: Usuarios)

    @Delete
    fun deleteUsuarios(usuarios: Usuarios)
}