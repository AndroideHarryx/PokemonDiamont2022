package com.bootcamp.pokemondiamont2022

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bootcamp.pokemondiamont2022.api.PokeApiDAO
import com.bootcamp.pokemondiamont2022.models.PokemonModels
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FragmentPoke : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var pokeconect : PokeApiDAO
    private var pokemonModels : PokemonModels?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        pokeconect = RetrofitClient.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_poke, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getPokeInfo("Pikachu")
    }

    fun getPokeInfo(pokemon: String){
        pokeconect.getPokemon(pokemon).enqueue(
            object : Callback<PokemonModels> {
                override fun onResponse(call: Call<PokemonModels>, response: Response<PokemonModels>) {
                    Log.d("RESPONSE", response.body().toString())

                    if(response.body() != null){
                        pokemonModels = response.body()
                    }
                }
                override fun onFailure(call: Call<PokemonModels>, t: Throwable) {

                }
            }
        )
    }

//    companion object {
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            FragmentPoke().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }

}