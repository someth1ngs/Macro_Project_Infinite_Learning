package com.dicoding.macroproject

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dicoding.macroproject.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var myUser : TextView
    private lateinit var hpBar : ProgressBar
    private lateinit var level : TextView
    private lateinit var expBar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(Home())
                R.id.habit -> replaceFragment(Habit())
                R.id.dailies -> replaceFragment(Dailies())
                R.id.task -> replaceFragment(Task())
                R.id.gamify -> replaceFragment(Gamify())
            }
            true
        }

        myUser = findViewById(R.id.myUser)
        hpBar = findViewById(R.id.hpBar)
        level = findViewById(R.id.level)
        expBar = findViewById(R.id.expBar)
        val username = intent.getParcelableExtra<User>("User")?.username
        val health = intent.getParcelableExtra<User>("User")?.health
        val levels = intent.getParcelableExtra<User>("User")?.level
        val experience = intent.getParcelableExtra<User>("User")?.exp
        myUser.text = "$username"
        if (health != null) {
            hpBar.progress = health
        }
        level.text = "Lvl. $levels"
        if (experience != null) {
            expBar.progress = experience
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}