package com.bootcamp.pokemondiamont2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ContieneMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contiene_menu)

        val mifragmento = FragmentMenuTrainer()
        supportFragmentManager.beginTransaction()
            .add(R.id.contiene_menu, mifragmento)
            .commit()
    }
}