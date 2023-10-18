package com.dicoding.macroproject.task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import com.dicoding.macroproject.R
import com.dicoding.macroproject.databinding.ActivityTodoCreateTaskBinding

class TodoCreateTask : AppCompatActivity() {

    private lateinit var binding: ActivityTodoCreateTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoCreateTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnDone = findViewById<Button>(R.id.doneTask)

        val feelings = resources.getStringArray(R.array.feelings)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, feelings)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

        btnDone.setOnClickListener {
            val intent = Intent(this, TodoViewAllTask::class.java)
            startActivity(intent)
        }
    }
}
