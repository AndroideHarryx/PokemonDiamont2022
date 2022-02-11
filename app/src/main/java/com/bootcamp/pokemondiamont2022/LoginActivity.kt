package com.bootcamp.pokemondiamont2022

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

        btn_login = findViewById(R.id.btn_login)
        txt_registrar = findViewById(R.id.txt_registrar)
        txt_usuario = findViewById(R.id.txt_user)
        txt_contrasenia = findViewById(R.id.txt_pass)
        /*******/
        login()

    }

    private fun login(){
        btn_login.setOnClickListener(){

        }
    }

}