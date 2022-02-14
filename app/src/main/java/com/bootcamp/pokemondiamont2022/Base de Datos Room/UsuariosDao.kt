package com.bootcamp.pokemondiamont2022.BasedeDatosRoom

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuariosDao {

    @Query("SELECT*FROM Usuarios")
    fun getAllUser(): List<Usuarios>

    @Query("SELECT*FROM Usuarios WHERE id = :id")
    fun getById(id:Int):Usuarios

    @Insert
    fun insertUse(usuarios: Usuarios)

    @Delete
    fun deleteUser(usuarios: Usuarios)

}