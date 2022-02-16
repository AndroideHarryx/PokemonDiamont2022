package com.bootcamp.pokemondiamont2022.fragment

import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.PointerIcon
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.pokemondiamont2022.MainMenuActivity
import com.bootcamp.pokemondiamont2022.PokemonAdapter
import com.bootcamp.pokemondiamont2022.R
import com.bootcamp.pokemondiamont2022.RetrofitClient
import com.bootcamp.pokemondiamont2022.api.PokeApi
import com.bootcamp.pokemondiamont2022.pokemon.PokemonList
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PokedexFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PokedexFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var retroFitConnection: PokeApi
    private var pokemonListModel: PokemonList?= null
//    lateinit var pokemonImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var activityParent = activity as MainMenuActivity

        lateinit var pokemonAdapter : PokemonAdapter
        lateinit var recyclerVariable : RecyclerView


        retroFitConnection = RetrofitClient.getInstance()
        retroFitConnection.getPokemonList("10","20").enqueue(

            object : Callback<PokemonList> {
                override fun onResponse(call: Call<PokemonList>, response: Response<PokemonList>) {
                    Log.d("RESPONSE", response.body().toString())

                    if(response.body() != null) {
                        pokemonListModel = response.body()
                    }
                    pokemonAdapter = PokemonAdapter(pokemonListModel?.results)
                    recyclerVariable = view.findViewById(R.id.recycler_container)
                    recyclerVariable.layoutManager = LinearLayoutManager(activityParent, LinearLayoutManager.VERTICAL, false)
                    recyclerVariable.adapter = pokemonAdapter
                }
                override fun onFailure(call: Call<PokemonList>, t: Throwable) {
                    Log.d("Error", t.toString())
                }
            }
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokedex, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PokedexFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PokedexFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}