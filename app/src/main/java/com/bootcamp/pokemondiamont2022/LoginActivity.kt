package com.bootcamp.pokemondiamont2022

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.bootcamp.pokemondiamont2022.database.PokeDatabase
import com.bootcamp.pokemondiamont2022.usuarios.UsuariosDAO
import android.media.MediaPlayer

class LoginActivity : AppCompatActivity() {

    lateinit var dialog: Dialog
    lateinit var txt_log_usuario: TextView
    lateinit var txt_log_password: TextView
    lateinit var btn_ingresa:Button
    lateinit var btn_crea:Button
    lateinit var db: PokeDatabase
    lateinit var usuadao: UsuariosDAO
    lateinit var mp : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db= PokeDatabase.getInstance(this)!!
        usuadao= db.usuariosDAO()

        txt_log_usuario=findViewById(R.id.txt_log_usuario)
        txt_log_password=findViewById(R.id.txt_log_password)
        btn_ingresa=findViewById(R.id.btn_log_inicia)
        btn_crea=findViewById(R.id.btn_log_crea)
        dialog=Dialog(this)
        mp = MediaPlayer.create(this, R.raw.fondo)

        //al presionar el boton ingresar lo que se hará es comparar con la bd
        //para darnos el acceso al menu
        btn_ingresa.setOnClickListener{
            val resulset = usuadao.findUsuariosByName(txt_log_usuario.text.toString())
            if(txt_log_usuario.text.toString() == resulset.username && txt_log_password.text.toString() == resulset.password){
                //si se cumple la condicion ingresamos al menu
                startActivity(Intent(this,PokemonHostActivity::class.java))
                mp.start()
            }else{
                //si no se cumple la condicion entonces muestra el mensaje de error
                dialog.setContentView(R.layout.popup)
//                dialog.onBackPressed()
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
        //al presionar el boton crear nos lleva a un formulario para crear un nuevo usuario
        btn_crea.setOnClickListener{
            startActivity(Intent(this,CreaUsuarios::class.java))
            this.onStop()
        }
    }
}