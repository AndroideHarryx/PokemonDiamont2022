package com.bootcamp.pokemondiamont2022

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AdapterHost(private var mList: ArrayList<pokemon>, val cback:(img: String, nombre: String)->Unit): RecyclerView.Adapter<AdapterHost.ViewHolder>() {
    inner class ViewHolder(ItView: View): RecyclerView.ViewHolder(ItView){
        val imgView: ImageView = ItView.findViewById(R.id.img_formapokemon)
        val nameView: TextView = ItView.findViewById(R.id.txt_namepokemon)
        val cView: CardView = ItView.findViewById(R.id.card_recycler)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokeapi_recycler,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val urlFinal: List<String> = mList[position].url!!.split("/")
        val idImagen: Int = urlFinal[urlFinal.size-2].toInt()

        Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + idImagen.toString() + ".png").into(holder.imgView)
        holder.nameView.text = mList[position].nombre
        holder.cView.setOnClickListener{
            cback(mList[position].url,mList[position].nombre)
        }
    }

    override fun getItemCount() =  mList.size

}