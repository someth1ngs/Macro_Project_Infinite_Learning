package com.dicoding.macroproject

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.ActivityChooserView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.dicoding.macroproject.databinding.ActivityCreateDailiesBinding
import com.dicoding.macroproject.databinding.FragmentDailiesBinding
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.YEAR

class CreateDailies : AppCompatActivity() {


    private lateinit var binding: ActivityCreateDailiesBinding
    private lateinit var tvDatePicker: TextView
    private lateinit var btnDatePicker: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_dailies)

        binding =ActivityCreateDailiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //        intent back from create activity
        binding.imageButtonRepeat.setOnClickListener {
            finish()
        }


        //        intent create from create activity
        binding.creatRepeatable.setOnClickListener {
            finish()
        }




        //        datepicker
        tvDatePicker = findViewById(R.id.tvDate)
        btnDatePicker = findViewById(R.id.btnDatePicker)

        val myCalendar = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(myCalendar)
        }

        btnDatePicker.setOnClickListener {
            DatePickerDialog(this, datePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }



    }

    private fun updateLable(myCalendar: Calendar) {
        var myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        tvDatePicker.setText(sdf.format(myCalendar.time))

    }



}
