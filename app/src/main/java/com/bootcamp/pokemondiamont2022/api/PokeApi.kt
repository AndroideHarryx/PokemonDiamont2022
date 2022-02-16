package com.bootcamp.pokemondiamont2022.api

import com.bootcamp.pokemondiamont2022.models.PokemonFormsModel
import com.bootcamp.pokemondiamont2022.models.PokemonRespuesta
import com.bootcamp.pokemondiamont2022.models.SimplePokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi{

    @GET("pokemon/{id}")
    fun getPokemon(@Path("id") id: Int): Call<PokemonRespuesta>

    @GET("/api/v2/pokemon-form/{name}/")
    fun getPokemonForms(@Path("name") name: String): Call<PokemonFormsModel>

    @GET("pokemon")
    fun getPokemonList(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<SimplePokemon>
}