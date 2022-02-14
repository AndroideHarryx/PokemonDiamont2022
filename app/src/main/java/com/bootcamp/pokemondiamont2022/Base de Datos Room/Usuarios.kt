package com.bootcamp.pokemondiamont2022.BasedeDatosRoom

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Usuarios")
data class Usuarios(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val nombre: String,
    val password: Int
)