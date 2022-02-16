package com.bootcamp.pokemondiamont2022

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.pokemondiamont2022.api.PokeApi
import com.bootcamp.pokemondiamont2022.models.PokemonList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FragmentPoke : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var pokemonListModels: PokemonList?= null
    lateinit var pokeconec: PokeApi
    lateinit var pokeAdapter: PokeAdapter
    lateinit var recyView: RecyclerView

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
        return inflater.inflate(R.layout.fragment_poke, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var activityParent = activity as PokemonHostActivity
        pokeconec = RetrofitClient.getInstance()

        //llamamos a los pokemon de acuerdo a dos parametros, limit sería la cantidad total a listar
        //y start sería desde que pokemon empieza a listar
        pokeconec.getPokemonList("386","0").enqueue(
            object : Callback<PokemonList> {
                override fun onResponse(call: Call<PokemonList>, response: Response<PokemonList>) {
                    Log.d("RESPONSE", response.body().toString())

                    if(response.body() != null) {
                        pokemonListModels = response.body()
                    }
                    pokeAdapter = PokeAdapter(pokemonListModels?.results as List<PokemonList.Result>)
                    recyView = view.findViewById(R.id.rv_pokedex)
                    recyView.layoutManager = GridLayoutManager(activityParent, 3)
                    recyView.adapter = pokeAdapter
                }
                override fun onFailure(call: Call<PokemonList>, t: Throwable) {
                    Log.d("Error", t.toString())
                }
            }
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentPoke().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}