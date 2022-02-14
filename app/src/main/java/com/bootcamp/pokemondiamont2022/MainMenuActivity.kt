package com.bootcamp.pokemondiamont2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatDelegate
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainMenuActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle
    lateinit var mainMenu: DrawerLayout
    lateinit var slideMenu : NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        supportActionBar!!.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        slideMenu = findViewById(R.id.slide_menu)
        mainMenu = findViewById(R.id.main_menu)

        toggle = ActionBarDrawerToggle(this,mainMenu,R.string.open,R.string.close)
        mainMenu.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        /** Acciones **/

//        slideMenu.setNavigationItemSelectedListener{
//            it.isChecked = true
//            when(it.itemId){
//                R.id.home_slide_menu-> replaceFragment(HomeFragment(),it.title.toString())
//                R.id.pokedex_slide_menu-> replaceFragment(PokedexFragment(),it.title.toString())
//            }
//            true
//        }
    }

    private fun replaceFragment(fragment: Fragment, title: String){
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragment_layout,fragment)
        fragmentTransition.commit()
        mainMenu.closeDrawers()
        setTitle(title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}