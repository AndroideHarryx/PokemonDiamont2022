package com.bootcamp.pokemondiamont2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    lateinit var btn_login: Button
    lateinit var txt_registrar: TextView
    lateinit var txt_usuario: EditText
    lateinit var txt_contrasenia: EditText
    var userdb=""
    var passdb=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var intentHost=Intent(this, PokemonHostActivity::class.java)
        btn_login = findViewById(R.id.btn_login)
        txt_registrar = findViewById(R.id.txt_registrar)
        txt_usuario = findViewById(R.id.txt_user)
        txt_contrasenia = findViewById(R.id.txt_pass)
        /*******/


        btn_login.setOnClickListener() {
            if(login(txt_usuario.text.toString(), txt_contrasenia.text.toString())){
                startActivity(intentHost)
            }
        }
        registrarse()
    }

    private fun login(usertxt: String, passtxt: String): Boolean{
        var esCorrecto:Boolean = false


        return esCorrecto
    }
    private fun registrarse(){
        
    }
}