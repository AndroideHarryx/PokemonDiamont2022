package com.bootcamp.pokemondiamont2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.bootcamp.pokemondiamont2022.database.AppDatabase

class LoginActivity : AppCompatActivity() {

    lateinit var username : String
    private lateinit var password: String
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Crear una instancia de la base de datos:
        val db = AppDatabase.getInstance(this)

    }
}