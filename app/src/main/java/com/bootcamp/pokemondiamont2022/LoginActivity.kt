package com.bootcamp.pokemondiamont2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {

    lateinit var btn_login: Button
    lateinit var txt_registrar: TextView
    lateinit var txt_usuario: EditText
    lateinit var txt_contrasenia: EditText
    var userdb="a"
    var passdb="1"
    lateinit var txt_Error: TextView

    lateinit var bd: AppDatabase
    lateinit var usuario1: usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var intentHost=Intent(this, PokemonHostActivity::class.java)
        btn_login = findViewById(R.id.btn_login)
        txt_registrar = findViewById(R.id.txt_registrar)
        txt_usuario = findViewById(R.id.txt_user)
        txt_contrasenia = findViewById(R.id.txt_pass)
        txt_Error = findViewById(R.id.txt_error)

        bd = AppDatabase.getInstance(this)!!

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
        if(usertxt.isNotEmpty() && passtxt.isNotEmpty()){
            //llamar a consulta bd
                if(bd.usersDao().getByUser(usertxt,passtxt)!=null){
                    usuario1 = bd.usersDao().getByUser(usertxt,passtxt)
                    userdb=usuario1.user
                    passdb=usuario1.pass
                }
            if(usertxt==userdb&&passtxt==passdb){
                esCorrecto=true
            }else if(usertxt!=userdb && passtxt!=passdb){
                txt_Error.setText("Usuario y contraseña incorrectos!")
                animar()
            }else if(passtxt!=passdb){
                txt_Error.setText("Contraseña incorrecta!")
                animar()
            }else if(usertxt!=userdb){
                txt_Error.setText("Usuario incorrecto!")
                animar()
            }
        }else if(usertxt.isNotEmpty()){
            txt_Error.setText("Ingrese contraseña!")
            animar()
        }else if(passtxt.isNotEmpty()){
            txt_Error.setText("Ingrese usuario!")
            animar()
        }else{
            txt_Error.setText("Campos vacios! Ingrese usuario y contraseña")
            animar()
        }

        return esCorrecto
    }
    private fun registrarse(){
        txt_registrar.setOnClickListener(){
            var intentRegistrarse = Intent(this,RegisterActivity::class.java)
            startActivity(intentRegistrarse)
        }
    }
    fun animar(){
        var animationSlideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down)
        txt_Error.isVisible=true
        txt_Error.startAnimation(animationSlideDown)
        txt_Error.isVisible=false
    }
}