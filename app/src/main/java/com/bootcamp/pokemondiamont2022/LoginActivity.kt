package com.bootcamp.pokemondiamont2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.bootcamp.pokemondiamont2022.database.PokedexDatabase

class LoginActivity : AppCompatActivity() {

    lateinit var usernameEditText: TextView
    lateinit var passwordEditText: TextView
    lateinit var loginButton: Button
    lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar!!.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val db = PokedexDatabase.getInstance(this)
        val userDao = db?.userDao()

        var registerIntent = Intent(this, RegisterActivity::class.java)
        var menuIntent = Intent(this, MainMenuActivity::class.java)

        usernameEditText = findViewById(R.id.username_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        loginButton = findViewById(R.id.login_button)
        registerButton = findViewById(R.id.register_button)

        loginButton.setOnClickListener{
            val resultSet = userDao?.findUserByName(usernameEditText.text.toString())
            if(usernameEditText.text.toString() == resultSet?.username && passwordEditText.text.toString() == resultSet.password){
                startActivity(menuIntent)
            } else{
                Toast.makeText(this, "Incorrect user or password", Toast.LENGTH_SHORT).show()
            }
        }

        registerButton.setOnClickListener{
            startActivity(registerIntent)
            this.onStop()
        }

    }
}