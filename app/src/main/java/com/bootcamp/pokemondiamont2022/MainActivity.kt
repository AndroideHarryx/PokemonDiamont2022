package com.bootcamp.pokemondiamont2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            /*Se inicia la actividad de loggin*/
        val intentoLogin = Intent(this, PokemonHost::class.java)
        startActivity(intentoLogin)

    }
}