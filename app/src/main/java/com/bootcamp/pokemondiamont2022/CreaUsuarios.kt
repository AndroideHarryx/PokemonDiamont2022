package com.bootcamp.pokemondiamont2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.bootcamp.pokemondiamont2022.database.PokeDatabase
import com.bootcamp.pokemondiamont2022.usuarios.Usuarios
import com.bootcamp.pokemondiamont2022.usuarios.UsuariosDAO
import java.util.*

class CreaUsuarios : AppCompatActivity() {
    lateinit var crea_usuario: TextView
    lateinit var crea_pass: TextView
    lateinit var crea_pass_veri: TextView
    lateinit var crea_btn_crea: TextView
    lateinit var db: PokeDatabase
    lateinit var usudao: UsuariosDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crea_usuarios)

        crea_usuario=findViewById(R.id.txt_crea_usuario)
        crea_pass=findViewById(R.id.txt_crea_password)
        crea_pass_veri=findViewById(R.id.txt_crea_password_verifica)
        crea_btn_crea=findViewById(R.id.btn_crea_aceptar)

        db= PokeDatabase.getInstance(this)!!
        usudao= db.usuariosDAO()

        //al presionar el boton crear luego de llenar los datos requeridos podremos guardar a la bd
        crea_btn_crea.setOnClickListener{
            usudao?.insertUsuarios(
                Usuarios(
                    UUID.randomUUID().toString(),
                    crea_usuario.text.toString(),
                    crea_pass.text.toString()
                )
            )
            this.finish()
        }
    }
}