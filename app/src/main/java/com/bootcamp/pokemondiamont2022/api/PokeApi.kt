package com.bootcamp.pokemondiamont2022.api

import android.telecom.Call
import com.bootcamp.pokemondiamont2022.Modelos.PokemonFormsModel
import com.bootcamp.pokemondiamont2022.Modelos.PokemonModel
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {
    @GET("/api/v2/pokemon/{name}/")
    fun getPokemon(@Path("name") name: String): retrofit2.Call<PokemonModel>

    @GET("/api/v2/pokemon-form/{name}/")
    fun getPokemonForms(@Path("name") name: String): retrofit2.Call<PokemonFormsModel>
}