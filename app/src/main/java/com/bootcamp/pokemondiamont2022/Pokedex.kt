package com.bootcamp.pokemondiamont2022

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.bootcamp.pokemondiamont2022.api.PokeApi
import com.bootcamp.pokemondiamont2022.models.PokemonFormsModel
import com.bootcamp.pokemondiamont2022.models.PokemonModel
import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Pokedex.newInstance] factory method to
 * create an instance of this fragment.
 */
class Pokedex : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var rfConnection: PokeApi
    lateinit var imag: ImageView
    private var pokemonModel: PokemonModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokedex, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rfConnection = RetrofitClient.getInstance()
        getPokemonInfo("pikachu")
        imag = view.findViewById(R.id.imagen_pokemon)

        Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(imag)

        Activity().onBackPressed()

    }

    fun getPokemonInfo(pokemon: String){
        rfConnection.getPokemon("pikachu").enqueue(
            object: Callback<PokemonModel> {
                override fun onResponse(call: Call<PokemonModel>, response: Response<PokemonModel>){
                    Log.d("Response", response.body().toString())

                    if(response.body() != null){
                        pokemonModel = response.body()
                    }
                }
                override fun onFailure(call: Call<PokemonModel>, t: Throwable){

                }
            }
        )
    }

    fun getPokemonForms(pokemon: String){
        rfConnection.getPokemonForms("pikachu").enqueue(
            object : Callback<PokemonFormsModel>{
                override fun onResponse(call: Call<PokemonFormsModel>, response: Response<PokemonFormsModel>){
                    Log.d("RESPONSE", response.body().toString())
                }
                override fun onFailure(call: Call<PokemonFormsModel>, t: Throwable){

                }
            }
        )
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Pokedex.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Pokedex().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}