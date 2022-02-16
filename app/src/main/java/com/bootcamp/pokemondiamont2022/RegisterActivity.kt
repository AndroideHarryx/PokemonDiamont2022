package com.bootcamp.pokemondiamont2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import java.lang.Exception

class RegisterActivity : AppCompatActivity() {

    lateinit var txt_userf: EditText
    lateinit var txt_emailf: EditText
    lateinit var txt_fechaf: EditText
    lateinit var txt_pass1f: EditText
    lateinit var txt_pass2f: EditText
    lateinit var btn_register: Button

    lateinit var bd: AppDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        txt_userf=findViewById(R.id.txt_usuariof)
        txt_emailf=findViewById(R.id.txt_email)
        txt_fechaf=findViewById(R.id.txt_fechaf)
        txt_pass1f=findViewById(R.id.txt_passf)
        txt_pass2f=findViewById(R.id.txt_pass2f)
        btn_register=findViewById(R.id.btn_registrarf)

        bd= AppDatabase.getInstance(this)!!


        registrar()
    }

    fun registrar(){
        btn_register.setOnClickListener(){
            addUser()
            if(txt_userf.text.isNotEmpty() && txt_pass1f.text.isNotEmpty() && txt_pass2f.text.isNotEmpty()){

                //validar fecha, > 13
                if(txt_pass1f==txt_pass2f && txt_pass2f.text.toString()!="" && txt_pass1f.text.toString()!=""&&txt_userf.text.toString()!=""){
                    addUser()
                }


            }


        }
    }

    fun addUser(){
        bd.usersDao().insertUser(usuario(0,txt_userf.text.toString(),txt_pass1f.text.toString(),txt_emailf.text.toString(),txt_fechaf.text.toString()))
        txt_userf.setText("")
        txt_pass1f.setText("")
        txt_emailf.setText("")
        txt_pass2f.setText("")
        txt_fechaf.setText("")
    }
}