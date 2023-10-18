package com.dicoding.macroproject.task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import com.dicoding.macroproject.R

class TodoViewCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_view_category)

        val btnDon = findViewById<ImageButton>(R.id.createTas)

        btnDon.setOnClickListener {
            val intent = Intent(this, TodoCreateTask::class.java)
            startActivity(intent)
        }

        val progress_bar = findViewById<ProgressBar>(R.id.progress_bar)
        val text_view_progress = findViewById<TextView>(R.id.text_view_progress)

        progress_bar.progress = 0
        text_view_progress.text = "0%"

    }

}
