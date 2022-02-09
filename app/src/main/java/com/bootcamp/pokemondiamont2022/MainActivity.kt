package com.bootcamp.pokemondiamont2022

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bootcamp.pokemondiamont2022.api.PokeApi
import com.bootcamp.pokemondiamont2022.models.PokemonFormsModel
import com.bootcamp.pokemondiamont2022.models.PokemonModel
import com.example.testempty.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var rfconnection: PokeApi
//    lateinit var listaviva : LiveData<PokemonModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rfconnection = RetrofitClient.getInstance()

        rfconnection.getPokemon("pikachu").enqueue(

            object : Callback<PokemonModel>{
                override fun onResponse(call: Call<PokemonModel>, response: Response<PokemonModel>) {
                    Log.d("RESPONSE", response.body().toString())
                }

                override fun onFailure(call: Call<PokemonModel>, t: Throwable) {

                }
            }
        )
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
}
