package com.bootcamp.pokemondiamont2022.Datos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_usuarios")
data class EntidadUsuario (
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id") val id: Int = 0,
        @ColumnInfo(name = "nombre") val nombre: String,
        @ColumnInfo(name = "pass") val pass: String)
