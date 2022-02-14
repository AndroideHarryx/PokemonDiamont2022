package com.bootcamp.pokemondiamont2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {

    lateinit var btn_ingresa:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_ingresa=findViewById(R.id.btn_log_inicia)

        btn_ingresa.setOnClickListener{
            startActivity(Intent(this,PokemonHostActivity::class.java))
        }
    }
}