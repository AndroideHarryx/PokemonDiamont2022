package com.bootcamp.pokemondiamont2022

import com.bootcamp.pokemondiamont2022.api.PokeApiDAO
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        private val BASE_URL = "https://pokeapi.com"
        private var INSTANCE: PokeApiDAO? = null

        @Synchronized
        fun getInstance(): PokeApiDAO{
            if (INSTANCE == null){
                INSTANCE = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
                    .create(PokeApiDAO::class.java)
            }
            return INSTANCE as PokeApiDAO
        }
    }
}