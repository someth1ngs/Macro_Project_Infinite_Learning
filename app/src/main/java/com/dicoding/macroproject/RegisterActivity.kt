package com.dicoding.macroproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var  etUsername: EditText
    private lateinit var  etEmail: EditText
    private lateinit var  etPassword: EditText
    private lateinit var  etConfirmPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etUsername = findViewById(R.id.edt_username)
        etEmail = findViewById(R.id.edt_email)
        etPassword = findViewById(R.id.edt_password)
        etConfirmPassword = findViewById(R.id.edt_confirm_password)

        val btnRegister: Button = findViewById(R.id.btn_register)
        btnRegister.setOnClickListener(this)
    }

    fun login(v: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    fun goToLogin(v: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_register ->{
                val bundle = Bundle()
                bundle.putString("username", etUsername.text.toString())
                bundle.putString("password", etPassword.text.toString())

                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}
