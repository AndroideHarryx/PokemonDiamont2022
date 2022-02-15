package com.bootcamp.pokemondiamont2022

import com.bootcamp.pokemondiamont2022.api.PokeApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        private val BASE_URL = "https://pokeapi.co"
        private var INSTANCE: PokeApi? = null

        @Synchronized
        fun getInstance(): PokeApi {
            if (INSTANCE == null)
                INSTANCE = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
                    .create(PokeApi::class.java)
            return INSTANCE as PokeApi
        }
    }

}