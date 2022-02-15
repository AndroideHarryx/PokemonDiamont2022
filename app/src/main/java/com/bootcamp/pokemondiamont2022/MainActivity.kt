package com.bootcamp.pokemondiamont2022

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bootcamp.pokemondiamont2022.models.PokemonModel
import com.bootcamp.pokemondiamont2022.presenters.MainPresenter
import com.bootcamp.pokemondiamont2022.presenters.MainPresenter.ViewUpdater
import com.example.testempty.R

class MainActivity : AppCompatActivity(), ViewUpdater {

    lateinit var presenter: MainPresenter
    lateinit var texto: TextView
    lateinit var warning: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
        presenter.onCreatePresenter()
        presenter.getAPokemonInfo("Pikachu")
        texto = findViewById<TextView>(R.id.texto_ejemplo)
        warning = findViewById(R.id.warning_layout)
        texto.setOnClickListener {
            presenter.showAlert(warning)
        }
    }

    override fun updateString(pokemon: PokemonModel?) {
        Log.d("CLEAN_DATA", pokemon.toString())
    }
}
