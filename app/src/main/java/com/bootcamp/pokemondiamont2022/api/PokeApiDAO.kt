package com.bootcamp.pokemondiamont2022.api

import com.bootcamp.pokemondiamont2022.models.PokemonFormsModel
import com.bootcamp.pokemondiamont2022.models.PokemonModels
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiDAO {
    @GET("/api/v2/pokemon/{name}/")
    fun getPokemon(@Path("name") name: String): Call<PokemonModels>

    @GET("/api/v2/pokemon/{name}/")
    fun getPokemonForms(@Path("name") name: String): Call<PokemonFormsModel>
}