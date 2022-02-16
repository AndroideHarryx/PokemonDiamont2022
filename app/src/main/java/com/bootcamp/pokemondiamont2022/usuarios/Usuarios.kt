package com.bootcamp.pokemondiamont2022.usuarios

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//creamos la base de datos para nuestro formulario de cuentas
@Entity(tableName = "usuarios")
data class Usuarios(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "nombre") val username: String?,
    @ColumnInfo(name = "password") val password: String?
)