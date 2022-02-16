package com.bootcamp.pokemondiamont2022

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.pokemondiamont2022.models.PokemonList
import com.squareup.picasso.Picasso
//creamos el adapter
class PokeAdapter (var pokeList: List<PokemonList.Result>) : RecyclerView.Adapter<PokeAdapter.PokeHolder>(){
    inner class PokeHolder(view: View): RecyclerView.ViewHolder(view){
        var txt_poke : TextView = view.findViewById(R.id.txt_item_poke)
        var imgitem: ImageView = view.findViewById(R.id.img_item)

        fun bind(elementpokemonList: PokemonList.Result){
            txt_poke.text = elementpokemonList.name
            val urlPartes: List<String> = elementpokemonList.url!!.split("/")
            val nroImagen: Int = urlPartes[urlPartes.size-2].toInt()
            Log.d("NROPOKE", nroImagen.toString())
            Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"
                    + nroImagen.toString() + ".png").into(imgitem)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)

        return PokeHolder(view)
    }
    override fun onBindViewHolder(holder: PokeHolder, position: Int) {
        holder.bind(pokeList[position])
    }
    override fun getItemCount(): Int {
        return pokeList.size
    }
}