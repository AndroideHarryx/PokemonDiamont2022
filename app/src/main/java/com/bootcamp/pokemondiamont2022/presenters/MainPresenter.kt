package com.bootcamp.pokemondiamont2022.presenters

import android.util.Log
import com.bootcamp.pokemondiamont2022.RetrofitClient
import com.bootcamp.pokemondiamont2022.api.PokeApi
import com.bootcamp.pokemondiamont2022.models.PokemonFormsModel
import com.bootcamp.pokemondiamont2022.models.PokemonModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val viewUpdater: ViewUpdater) {

    lateinit var rfconnection: PokeApi
    private var pokemonModel: PokemonModel?= null

    fun onCreatePresenter(){
        rfconnection = RetrofitClient.getInstance()
    }

    fun getAPokemonInfo(pokemon: String){

        rfconnection.getPokemon("pikachu").enqueue(

            object : Callback<PokemonModel> {
                override fun onResponse(call: Call<PokemonModel>, response: Response<PokemonModel>) {
                    Log.d("RESPONSE", response.body().toString())

                    if(response.body() != null) {
                        pokemonModel = response.body()
                    }

                    viewUpdater.updateString(pokemonModel)
                }

                override fun onFailure(call: Call<PokemonModel>, t: Throwable) {

                }
            }
        )
    }

    fun getPokemonForms(pokemon: String){

        rfconnection.getPokemonForms("pikachu").enqueue(

            object : Callback<PokemonFormsModel>{
                override fun onResponse(call: Call<PokemonFormsModel>, response: Response<PokemonFormsModel>) {
                    Log.d("RESPONSE", response.body().toString())
                }

                override fun onFailure(call: Call<PokemonFormsModel>, t: Throwable) {

                }
            }
        )
    }

    interface ViewUpdater{
        fun updateString(string: PokemonModel?)
    }
}