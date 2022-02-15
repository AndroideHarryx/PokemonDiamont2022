package com.bootcamp.pokemondiamont2022.api

import com.bootcamp.pokemondiamont2022.pokemon.PokemonList
import com.bootcamp.pokemondiamont2022.pokemon.PokemonDescription
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi{

    @GET("/api/v2/pokemon/{name}/")
    fun getPokemonDescription(@Path("name") name: String): Call<PokemonDescription>

    @GET("/api/v2/pokemon/")
    fun getPokemonList(@Query("limit")  limit : String, @Query ("offset") start : String): Call<PokemonList>
}