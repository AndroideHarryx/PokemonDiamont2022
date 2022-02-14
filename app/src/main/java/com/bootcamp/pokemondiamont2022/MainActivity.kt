package com.bootcamp.pokemondiamont2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    /*** Propiedades,Variables**/
    lateinit var userName: EditText
    lateinit var password: EditText
    lateinit var login : Button
    lateinit var register : Button
    lateinit var User : String
    lateinit var Pass : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /** Llamando los ID **/

        login = findViewById(R.id.btnlogin)
        register = findViewById(R.id.btnsave)

        /** Aplicando una accion a los Botones **/

        login.setOnClickListener{
            val intent = Intent(this, PokemonHostActivity::class.java)
            startActivity(intent)
        }


        register.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        }

    }


}