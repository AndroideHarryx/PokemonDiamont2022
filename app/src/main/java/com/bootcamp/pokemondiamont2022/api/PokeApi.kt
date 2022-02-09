package com.bootcamp.pokemondiamont2022.api

import com.bootcamp.pokemondiamont2022.models.PokemonFormsModel
import com.bootcamp.pokemondiamont2022.models.PokemonModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi{

    @GET("/api/v2/pokemon/{name}/")
    fun getPokemon(@Path("name") name: String): Call<PokemonModel>

    @GET("/api/v2/pokemon-form/{name}/")
    fun getPokemonForms(@Path("name") name: String): Call<PokemonFormsModel>
}