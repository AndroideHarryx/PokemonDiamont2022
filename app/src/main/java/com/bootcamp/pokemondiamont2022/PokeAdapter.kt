package com.bootcamp.pokemondiamont2022

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PokeAdapter(val pokemon: List<poke>): RecyclerView.Adapter<PokeAdapter.PokeHolder>() {

    inner class PokeHolder(view: View): RecyclerView.ViewHolder(view){

        var nombrePokemon = view.findViewById<TextView>(R.id.nombre_pokemon)
        var imagenPokemon = view.findViewById<ImageView>(R.id.imagen_pokemon)

        fun bind(Elemento: poke){
            nombrePokemon.text = Elemento.nombrePokemon
            Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(imagenPokemon)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeAdapter.PokeHolder {

    }

    override fun onBindViewHolder(holder: PokeAdapter.PokeHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = pokemon.size
}