package com.bootcamp.pokemondiamont2022

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.bootcamp.pokemondiamont2022.Modelos.PokemonFormsModel
import com.bootcamp.pokemondiamont2022.Modelos.PokemonModel
import com.bootcamp.pokemondiamont2022.api.PokeApi


class PokedexFragment : Fragment() {
    lateinit var rfconnection: PokeApi


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rfconnection = RetrofitCliente.getInstance()

        rfconnection.getPokemon("pikachu").enqueue(

            object : retrofit2.Callback<PokemonModel> {
                override fun onResponse(call: retrofit2.Call<PokemonModel>, response: retrofit2.Response<PokemonModel>) {
                    Log.d("RESPONSE", response.body().toString())
                }

                override fun onFailure(call: retrofit2.Call<PokemonModel>, t: Throwable) {

                }
            }
        )
        rfconnection.getPokemonForms("pikachu").enqueue(

            object : retrofit2.Callback<PokemonFormsModel> {
                override fun onResponse(call: retrofit2.Call<PokemonFormsModel>, response: retrofit2.Response<PokemonFormsModel>) {
                    Log.d("RESPONSE", response.body().toString())
                }

                override fun onFailure(call: retrofit2.Call<PokemonFormsModel>, t: Throwable) {

                }
            }
        )
    }

}