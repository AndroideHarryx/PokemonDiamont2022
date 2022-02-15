package com.bootcamp.pokemondiamont2022.presenters

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.bootcamp.pokemondiamont2022.RetrofitClient
import com.bootcamp.pokemondiamont2022.api.PokeApi
import com.bootcamp.pokemondiamont2022.models.PokemonFormsModel
import com.bootcamp.pokemondiamont2022.models.PokemonModel
import com.example.testempty.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val viewUpdater: ViewUpdater) {

    lateinit var rfconnection: PokeApi
    private var pokemonModel: PokemonModel?= null
    var isOut = false
    lateinit var warning : View

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

    fun showAlert(view: View?) {
        view?.visibility = View.VISIBLE
        val animationIn: Animation = AnimationUtils.loadAnimation(view?.context, R.anim.slide_top_to_in)
        val animationOut: Animation = AnimationUtils.loadAnimation(view?.context, R.anim.slide_bottom_to_out)

        view?.startAnimation(animationIn)

        Handler(Looper.getMainLooper()).postDelayed({

            view?.startAnimation(animationOut)
            view?.let { warning = it }
            isOut = true
            onAnimationEnd()
        },2500)

    }

    interface ViewUpdater{
        fun updateString(string: PokemonModel?)
    }

    fun onAnimationEnd() {
        if (isOut)
            warning.visibility = View.GONE
    }

}