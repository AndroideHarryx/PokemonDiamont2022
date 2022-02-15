package com.bootcamp.pokemondiamont2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.bootcamp.pokemondiamont2022.database.AppDatabase
import com.bootcamp.pokemondiamont2022.database.User

class RegisterActivity : AppCompatActivity() {

    private lateinit var btSave: Button
    private lateinit var etUserName : String
    private lateinit var etDob : String
    private lateinit var etEmail: String
    private lateinit var etPassword: String
    private lateinit var etPasswordTwo: String
    private lateinit var btnGoback: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val db = AppDatabase.getInstance(this)
        btSave = findViewById(R.id.bt_save)

        btSave.setOnClickListener {
            etUserName = findViewById<EditText>(R.id.et_username).text.toString()
            etDob = findViewById<EditText>(R.id.et_dob).text.toString()
            etEmail = findViewById<EditText>(R.id.et_email).text.toString()
            etPassword = findViewById<EditText>(R.id.et_password).text.toString()
            etPasswordTwo = findViewById<EditText>(R.id.et_password_two).text.toString()

            if (etPassword.equals(etPasswordTwo)) {
                var newUser = User(null, etUserName, etDob, etEmail, etPassword)
                var dbResult = db?.userDao()?.insertUser(newUser)
                Toast.makeText(this, "The user has been created!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Passwords must be the same!", Toast.LENGTH_SHORT).show()
            }

        }

        btnGoback = findViewById(R.id.btn_goback)
        btnGoback.setOnClickListener { finish() }

    }
}