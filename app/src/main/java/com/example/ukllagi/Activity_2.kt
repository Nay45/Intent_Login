package com.example.ukllagi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Activity_2 : AppCompatActivity() {
    private lateinit var txtHello: TextView
    private lateinit var txtPass: TextView
    private var email: String? = null
    private var pass: String? = null

    private val KEY_EMAIL = "EA"
    private val KEY_PASS = "BRUH"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        txtHello = findViewById(R.id.tampil)
        txtPass = findViewById(R.id.ShowPass)

        val extras = intent.extras
        email = extras?.getString(KEY_EMAIL)
        pass = extras?.getString(KEY_PASS)
        txtHello.text = "Email : $email"
        txtPass.text = "Pass : $pass"
    }
}