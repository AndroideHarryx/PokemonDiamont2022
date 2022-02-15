package com.bootcamp.pokemondiamont2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.bootcamp.pokemondiamont2022.database.AppDatabase

class LoginActivity : AppCompatActivity() {

    lateinit var username : String
    private lateinit var password: String
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val db = AppDatabase.getInstance(this)
        btnLogin = findViewById(R.id.btn_login)
        btnRegister = findViewById(R.id.btn_register)

        btnLogin.setOnClickListener {
            username = findViewById<EditText>(R.id.et_username).text.toString()
            password = findViewById<EditText>(R.id.et_password).text.toString()

            val userDao = db?.userDao()
            val user = userDao?.getUserByUsername(username)
            if (user == null) {
                Toast.makeText(this, "User does not exist!", Toast.LENGTH_LONG).show()
            } else {
                if (user.password.equals(password)) {
                    // Ingresar a la App
                    //GlobalClass.username = username
                    intent = Intent(this, PokemonHostActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Password is not correct", Toast.LENGTH_LONG).show()
                }
            }
        }

        btnRegister.setOnClickListener {
            intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}