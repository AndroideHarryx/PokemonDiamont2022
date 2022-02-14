package com.bootcamp.pokemondiamont2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.bootcamp.pokemondiamont2022.BasedeDatosRoom.AppDataBase
import com.bootcamp.pokemondiamont2022.BasedeDatosRoom.Usuarios

class RegisterActivity : AppCompatActivity() {

    /** Variables y propiedades **/
    lateinit var userName: EditText
    lateinit var password: EditText
    lateinit var log : Button
    lateinit var register : Button
    lateinit var newUser : String
    lateinit var newPass : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        

        /** Base de Datos **/
        val db = AppDataBase.getInstance(this)
        val usuariosDao = db?.usuariosDao()
        usuariosDao?.insertUse(Usuarios(0, "nombre", 0))


        /** Llamando los ID **/
        userName = findViewById(R.id.newuser)
        password = findViewById(R.id.newpass)
        log = findViewById(R.id.logback)
        register = findViewById(R.id.registeruser)

        /** Funciones de los botones **/

        log.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            finish()
        }
        register.setOnClickListener{
            newUser = userName.text.toString()
            newPass = password.text.toString()


        }




    }
}