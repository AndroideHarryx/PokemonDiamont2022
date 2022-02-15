package com.bootcamp.pokemondiamont2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class PokemonHost : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_host)

        supportActionBar?.hide()

        val drawerLayout : DrawerLayout = findViewById(R.id.drawer)
        val navView : NavigationView = findViewById(R.id.navigation_view)
        var fragPokedex = Pokedex.newInstance("", "")

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.pokedex -> supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, fragPokedex)
                    .addToBackStack("null")
                    .commit()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}