package com.bootcamp.pokemondiamont2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_pokemon_host.*
import kotlinx.android.synthetic.main.content_host.*

class PokemonHostActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var txtbienvenida: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_host)
        txtbienvenida=findViewById(R.id.txt_bienvenida)

        /***para activar los eventos de los items del menu***/
        val navView: NavigationView=findViewById(R.id.nav_menu)
        navView.setNavigationItemSelectedListener(this)

        /******/
//        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this,drawerlayout,toolbar,R.string.open, R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerlayout.addDrawerListener(toggle)
        toggle.syncState()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_pokedex -> {
//                txtbienvenida.setText("")
                val frc_pokedex = PokemonDescriptionAoF.newInstance("","")
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fr_pokedex,frc_pokedex)
                    .addToBackStack(null)
                    .commit()
            }

        }
        drawerlayout.closeDrawer(GravityCompat.START)
        return true
    }

}