package com.bootcamp.pokemondiamont2022

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager

class ViewPagerAdapter (
    private val imagenes: List<ContieneMenu>
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>(){
    inner class ViewPagerViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){

        fun bind(contieneMenu: ContieneMenu){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_menu_trainer, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.bind(imagenes[position])

    }

    override fun getItemCount(): Int {
        return imagenes.size
    }
}