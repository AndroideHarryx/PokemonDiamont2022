package com.bootcamp.pokemondiamont2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.bootcamp.pokemondiamont2022.database.PokedexDatabase
import com.bootcamp.pokemondiamont2022.user.User
import java.util.*

class RegisterActivity : AppCompatActivity() {

    lateinit var newUsernameEditText: TextView
    lateinit var newPasswordEditText: TextView
    lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        newUsernameEditText = findViewById(R.id.new_username_edit_text)
        newPasswordEditText = findViewById(R.id.new_password_edit_text)
        saveButton = findViewById(R.id.save_button)

        val db = PokedexDatabase.getInstance(this)
        val userDao = db?.userDao()

        saveButton.setOnClickListener{
            userDao?.insertUser(
                User(
                    UUID.randomUUID().toString(),
                    newUsernameEditText.text.toString(),
                    newPasswordEditText.text.toString()
                )
            )
            this.finish()
        }

    }
}