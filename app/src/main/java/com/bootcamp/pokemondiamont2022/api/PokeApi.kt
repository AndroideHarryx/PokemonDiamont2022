package com.bootcamp.pokemondiamont2022.api

import com.bootcamp.pokemondiamont2022.models.PokemonList
import com.bootcamp.pokemondiamont2022.models.PokemonModels
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
//en esta interfase obtenemos por filtros de acuerdo a los modelos que creamos previamente
interface PokeApi {
    @GET("/api/v2/pokemon/{name}/")
    fun getPokemon(@Path("name") name: String): Call<PokemonModels>

    @GET("/api/v2/pokemon/")
    fun getPokemonList(@Query("limit") limit: String, @Query("offset") start: String): Call<PokemonList>
}