package com.bootcamp.pokemondiamont2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager

class PokemonHostActivity : AppCompatActivity() {
    lateinit var vp_menu:ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_host)

//        vp_menu=findViewById(R.id.vp_menu)
//
//        val adapter = ViewPagerAdapter()
//        vp_menu

    }
}