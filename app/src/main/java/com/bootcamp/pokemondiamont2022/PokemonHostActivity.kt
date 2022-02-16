package com.bootcamp.pokemondiamont2022

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class PokemonHostActivity : AppCompatActivity(){

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_host)

        var pokefragment = FragmentPoke.newInstance("","")
        drawerLayout=findViewById(R.id.drawerLayout)
        navView=findViewById(R.id.navView)

        toggle= ActionBarDrawerToggle(this,drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miItem1 -> supportFragmentManager.beginTransaction()
                    .add(R.id.contiene_Recycler,pokefragment)
                    .addToBackStack("null")
                    .commit()
                R.id.miItem2 -> Toast.makeText(applicationContext,
                    "Clicked Item 2",Toast.LENGTH_SHORT).show()

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