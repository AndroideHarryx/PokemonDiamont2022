package com.bootcamp.pokemondiamont2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Exception

class RegisterActivity : AppCompatActivity() {

    lateinit var txt_userf: EditText
    lateinit var txt_emailf: EditText
    lateinit var txt_fechaf: EditText
    lateinit var txt_pass1f: EditText
    lateinit var txt_pass2f: EditText
    lateinit var btn_register: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        txt_userf=findViewById(R.id.txt_usuariof)
        txt_emailf=findViewById(R.id.txt_email)
        txt_fechaf=findViewById(R.id.txt_fechaf)
        txt_pass1f=findViewById(R.id.txt_passf)
        txt_pass2f=findViewById(R.id.txt_pass2f)
        btn_register=findViewById(R.id.btn_registrarf)



    }
}