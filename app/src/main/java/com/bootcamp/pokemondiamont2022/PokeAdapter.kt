package com.bootcamp.pokemondiamont2022

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.pokemondiamont2022.api.PokeApi
import com.bootcamp.pokemondiamont2022.models.SimplePokemon
import com.squareup.picasso.Picasso
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class PokeAdapter(val pokemon: List<SimplePokemon>): RecyclerView.Adapter<PokeAdapter.PokeHolder>() {

    inner class PokeHolder(view: View): RecyclerView.ViewHolder(view){

        var nombrePokemon = view.findViewById<TextView>(R.id.nombre_pokemon)
        var imagenPokemon = view.findViewById<ImageView>(R.id.imagen_pokemon)



        fun bind(Elemento: poke){
            nombrePokemon.text = Elemento.nombrePokemon
            //Picasso.get().load("http://pokeapi.co/media/sprites/pokemon/" + Pokedex.getP).into(imagenPokemon)


        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)

        return PokeHolder(view)
    }

    override fun onBindViewHolder(holder: PokeAdapter.PokeHolder, position: Int) {
        holder.bind(pokemon[position])
    }

    override fun getItemCount(): Int = pokemon.size
}