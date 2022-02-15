package com.bootcamp.pokemondiamont2022

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.pokemondiamont2022.pokemon.PokemonList

class PokemonAdapter (var pokemonListList: List<PokemonList.Result>) : RecyclerView.Adapter<PokemonAdapter.PokemonHolder>(){

    inner class PokemonHolder (view: View): RecyclerView.ViewHolder(view){
        var timeTextView : TextView = view.findViewById(R.id.pokemon_text_view)
        fun bind(elementList: PokemonList.Result){
            timeTextView.text = elementList.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAdapter.PokemonHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)

        return PokemonHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        holder.bind(pokemonListList[position])
    }

    override fun getItemCount(): Int {
        return pokemonListList.size
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