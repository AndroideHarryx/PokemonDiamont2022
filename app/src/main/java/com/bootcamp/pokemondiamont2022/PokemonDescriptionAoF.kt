package com.bootcamp.pokemondiamont2022

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_item_pokemon.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PokemonDescriptionAoF.newInstance] factory method to
 * create an instance of this fragment.
 */
class PokemonDescriptionAoF : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    /****Recycler****/
    lateinit var recyclerView: RecyclerView
    lateinit var miadapter: AdapterHost
    var datos = ArrayList<pokemon>()

    /******api******/
    lateinit var rfconnection: PokeApi

    /****************************************/

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
        return inflater.inflate(R.layout.fragment_pokemon_description_ao, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_poke)
        recyclerView.layoutManager= LinearLayoutManager(activity)

        /*****************/

        rfconnection = RetrofitClient.getInstance()
        /***************/

        getPokemons(250,0)

    }
    ///////////////////////////////////
    //////////////////////////

    fun getPokemons(limit: Int,offset:Int){
        rfconnection.getPokemons(limit,offset).enqueue(
            object : Callback<Pokemons>{
                override fun onResponse(call: Call<Pokemons>, response: Response<Pokemons>) {
//                    Log.d("holi ", response.body()?.results?.get(10)?.url.toString())

                    for (i in response.body()?.results?.indices!!){
                        datos.add(pokemon(response.body()?.results?.get(i)?.url.toString(),response.body()?.results?.get(i)?.name.toString()))
                    }

                    Log.d("datos  ",datos.toString())
                    miadapter= AdapterHost(datos){
                        img, nombre ->
                        val frc_description = ItemPokemon.newInstance(img,nombre)
                        parentFragmentManager
                            .beginTransaction()
                            .replace(R.id.fr_pokedex,frc_description)
                            .addToBackStack(null).commit()

                    }
                    recyclerView.apply {
                        layoutManager =LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
                        adapter=miadapter
                    }
                }

                override fun onFailure(call: Call<Pokemons>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            }
        )
    }

    ///////////////////////
    /////////////////////////////////


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PokemonDescriptionAoF.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PokemonDescriptionAoF().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}