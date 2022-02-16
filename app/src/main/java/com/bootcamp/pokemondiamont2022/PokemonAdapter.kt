package com.bootcamp.pokemondiamont2022

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.pokemondiamont2022.pokemon.PokemonList
import com.squareup.picasso.Picasso

class PokemonAdapter (var pokemonListList: List<PokemonList.Result?>?) : RecyclerView.Adapter<PokemonAdapter.PokemonHolder>(){

    inner class PokemonHolder (view: View): RecyclerView.ViewHolder(view){
        var timeTextView : TextView = view.findViewById(R.id.pokemon_name)
        var pokemonImage : ImageView = view.findViewById(R.id.pokemon_image)
        lateinit var pokemonUrlList : List<String>
        var pokemonImageId = ""
        fun bind(elementList: PokemonList.Result?){
            timeTextView.text = elementList?.name
            pokemonUrlList = elementList!!.url!!.split("/")
            pokemonImageId = pokemonUrlList[pokemonUrlList.size-2]
            Log.d("pokemonUrlList", pokemonUrlList.toString())
            Picasso.get()
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+pokemonImageId+".png")
                .into(pokemonImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAdapter.PokemonHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)

        return PokemonHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        holder.bind(pokemonListList?.get(position))
    }

    override fun getItemCount(): Int {
        Log.d("pokemonListList.size",pokemonListList?.size.toString())
        return pokemonListList?.size!!
    }

}

//class RecordAdapter (var recordList: List<Record>) : RecyclerView.Adapter<RecordAdapter.RecordHolder>(){
//    inner class RecordHolder (view: View): RecyclerView.ViewHolder(view){
//        var timeTextView : TextView = view.findViewById(R.id.game_time_textview)
//        var resultTextView : TextView = view.findViewById(R.id.game_result_textview)
//        fun bind(elementList: Record){
//            timeTextView.text = elementList.time
//            resultTextView.text = elementList.result
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordAdapter.RecordHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_recycler, parent, false)
//
//        return RecordHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: RecordHolder, position: Int) {
//        holder.bind(recordList[position])
//    }
//
//    override fun getItemCount(): Int {
//        return recordList.size
//    }
//
//}