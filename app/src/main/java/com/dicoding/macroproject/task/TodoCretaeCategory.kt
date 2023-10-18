package com.dicoding.macroproject.task

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.dicoding.macroproject.R
import com.nvt.color.ColorPickerDialog


class TodoCretaeCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_cretae_category)

        val btn = findViewById<Button>(R.id.btnShowColorPicker)
        val btnDone = findViewById<Button>(R.id.done)

        btn.setOnClickListener {
            val colorPicker = ColorPickerDialog(
                this,
                Color.BLACK, // color init
                true, // true is show alpha
                object : ColorPickerDialog.OnColorPickerListener {
                    override fun onCancel(dialog: ColorPickerDialog?) {
                        // handle click button Cancel
                    }

                    override fun onOk(dialog: ColorPickerDialog?, colorPicker: Int) {
                        btn.setBackgroundColor(colorPicker)
                    }
                })
            colorPicker.show()
        }

        btnDone.setOnClickListener {
            val intent = Intent(this, TodoViewCategory::class.java)
            startActivity(intent)
        }


    }
}