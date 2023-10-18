package com.dicoding.macroproject.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.macroproject.R


class TodoViewAllTask : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_view_all_task)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val tasks = mutableListOf(
            Task(0, "Belajar Koding", "Belajar Dasar Kotlin dan Java", "10:30 PM", false),
            Task(2, "Belajar Flutter", "Belajar Dasar Kotlin dan Java", "10:30 PM", false),

        )

        adapter = TaskAdapter(this, tasks)
        recyclerView.adapter = adapter
    }
}