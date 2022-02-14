package com.bootcamp.pokemondiamont2022

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bootcamp.pokemondiamont2022.models.PokemonModel
import com.bootcamp.pokemondiamont2022.presenters.MainPresenter
import com.bootcamp.pokemondiamont2022.presenters.ViewUpdater
import com.example.testempty.R

class MainActivity : AppCompatActivity(), ViewUpdater {

    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
        presenter.onCreatePresenter()
        presenter.getAPokemonInfo("Pikachu")

    }

    override fun updateString(pokemon: PokemonModel?) {
        Log.d("CLEAN_DATA", pokemon.toString())
    }
}
