package com.dicoding.macroproject.gamify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.dicoding.macroproject.Gamify
import com.dicoding.macroproject.Home
import com.dicoding.macroproject.R

class Inventory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventory)

        val InvenBtn = findViewById<TextView>(R.id.inventory)
        val SocialBtn = findViewById<TextView>(R.id.social)

        InvenBtn.setOnClickListener {
            val intent = Intent(this, Inventory::class.java)
            startActivity(intent)
        }

        SocialBtn.setOnClickListener {
            val intent = Intent(this, Social::class.java)
            startActivity(intent)
        }

    }
}