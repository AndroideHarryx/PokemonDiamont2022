package com.bootcamp.pokemondiamont2022

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
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
 * Use the [ItemPokemon.newInstance] factory method to
 * create an instance of this fragment.
 */
class ItemPokemon : Fragment() {
    // TODO: Rename and change types of parameters
    private var id: String? = null
    private var nombre: String? = null
    /*******************************/
    lateinit var txt_pokemon: TextView
    lateinit var img_pokemon: ImageView
    lateinit var txt_nropokemon: TextView
    lateinit var txt_tipos: TextView
    lateinit var txt_height: TextView
    lateinit var txt_weight:TextView

    lateinit var rfconnection: PokeApi

    /******************************/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getString(ARG_PARAM1)
            nombre = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_pokemon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txt_pokemon=view.findViewById(R.id.txt_nombrepoke)
        img_pokemon=view.findViewById(R.id.img_pokemon)
        txt_nropokemon=view.findViewById(R.id.txt_idpokedex)
        txt_tipos=view.findViewById(R.id.txt_tipos)
        txt_height=view.findViewById(R.id.txt_height)
        txt_weight=view.findViewById(R.id.txt_weight)

        rfconnection = RetrofitClient.getInstance()

      /*  getAPokemonInfo(nombre!!)
        getPokemonForms(nombre!!)
        txt_pokemon.text=nombre
*/
    }


    fun getAPokemonInfo(pokemon: String){

        rfconnection.getPokemon(pokemon).enqueue(

            object : Callback<PokemonModel> {
                override fun onResponse(call: Call<PokemonModel>, response: Response<PokemonModel>) {
                    Log.d("RESPONSE", response.body().toString())

                    if(response.body() != null) {
                       /* txt_nropokemon.text="Nro: "+response.body()?.id.toString()
                        txt_tipos.text="Tipo(s): "+response.body()?.types.toString()
                        txt_height.text="Height: "+response.body()?.height.toString()
                        txt_weight.text="Weight: "+response.body()?.weight.toString()*/
                    }
                }

                override fun onFailure(call: Call<PokemonModel>, t: Throwable) {

                }
            }
        )
    }

    fun getPokemonForms(pokemon: String){

        rfconnection.getPokemonForms(pokemon).enqueue(

            object : Callback<PokemonFormsModel>{
                override fun onResponse(call: Call<PokemonFormsModel>, response: Response<PokemonFormsModel>) {
                    Log.d("RESPONSE", response.body().toString())
                    /*Picasso.get().load(response.body()?.sprites?.frontDefault.toString()).into(img_pokemon)*/
                }

                override fun onFailure(call: Call<PokemonFormsModel>, t: Throwable) {

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
         * @return A new instance of fragment ItemPokemon.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ItemPokemon().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}