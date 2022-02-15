package com.bootcamp.pokemondiamont2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.bootcamp.pokemondiamont2022.Datos.UsuarioDao
import com.bootcamp.pokemondiamont2022.Datos.UsuarioDatabase

class Loggin : AppCompatActivity() {

    lateinit var db: UsuarioDao
    lateinit var btnIngresar: Button
    lateinit var btnRegistrar: Button
    lateinit var txtNombre: EditText
    lateinit var txtPass: EditText
    lateinit var txtUsuarioIncorrecto: TextView
    lateinit var txtContraseñaIncorrecta: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loggin)

                /*Se inician los objetos*/
        db = UsuarioDatabase.getInstance(this)?.usuarioDao()!!
        btnIngresar = findViewById(R.id.btn_ingresar)
        btnRegistrar = findViewById(R.id.btn_registrar)
        txtNombre = findViewById(R.id.nombre)
        txtPass = findViewById(R.id.contraseña)
        txtContraseñaIncorrecta = findViewById(R.id.contraseña_incorrecta)
        txtUsuarioIncorrecto = findViewById(R.id.usuario_incorrecto)
        val intentoHost = Intent(this, PokemonHost::class.java)
        var usuarioLogeado: String? = db.getById(db.getByName(txtNombre.text.toString())?.id)?.nombre
        var passLogeado: String? = db.getById(db.getByName(txtNombre.text.toString())?.id)?.pass

                /*si se presiona el boton de ingresar*/
        btnIngresar.setOnClickListener{

                        /*En caso de que coincida el usuario pero no la contraseña*/
            if(txtNombre.text.toString() == usuarioLogeado && txtPass.text.toString() != passLogeado){
                txtContraseñaIncorrecta.alpha = .5f
                txtContraseñaIncorrecta.visibility = View.VISIBLE
                        /*Animacion para indicar el error*/
                txtContraseñaIncorrecta.animate().apply{
                    interpolator = LinearInterpolator()
                    duration = 5000
                    alpha(1f)
                    startDelay = 500
                }.withEndAction{
                    txtContraseñaIncorrecta.visibility = View.GONE
                }.start()
            }

                    /*En caso que no coincida el nombre de usuario*/
            else if(txtNombre.text.toString() != usuarioLogeado && txtPass.text.toString() == passLogeado){
                txtUsuarioIncorrecto.alpha = .5f
                txtUsuarioIncorrecto.visibility = View.VISIBLE
                /*Animacion para indicar el error*/
                txtUsuarioIncorrecto.animate().apply{
                    interpolator = LinearInterpolator()
                    duration = 5000
                    alpha(1f)
                    startDelay = 500
                }.withEndAction{
                    txtUsuarioIncorrecto.visibility = View.GONE
                }.start()
            }

                /*En caso de que coincidan los datos*/
            else if(txtNombre.text.toString() == usuarioLogeado && txtPass.text.toString() == passLogeado){
                startActivity(intentoHost)
            }
        }
    }
}