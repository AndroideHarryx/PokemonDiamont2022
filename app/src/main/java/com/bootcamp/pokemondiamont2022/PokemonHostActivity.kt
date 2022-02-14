package com.bootcamp.pokemondiamont2022

import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class PokemonHostActivity : AppCompatActivity(){

    /** Variables y propiedades **/

    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_host)

        /** Visualizaciones **/

        val nav_views : NavigationView = findViewById(R.id.nav_view)
        drawerLayout = findViewById(R.id.drawerlayout)


        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        /** Acciones **/

        nav_views.setNavigationItemSelectedListener{
            it.isChecked = true
            when(it.itemId){
                R.id.nav_home-> replaceFragment(HomeFragment(),it.title.toString())
                R.id.nav_pokedex-> replaceFragment(PokedexFragment(),it.title.toString())
            }
            true
        }

    }
    private fun replaceFragment(fragment: Fragment,title: String){
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.frameLayout,fragment)
        fragmentTransition.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}