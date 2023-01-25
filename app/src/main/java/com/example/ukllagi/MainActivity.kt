package com.example.ukllagi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var btnSend: Button

    private lateinit var PassInput: EditText
    private lateinit var ShowPass: CheckBox

    private val KEY_EMAIL = "EA"
    private val KEY_PASS = "BRUH"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.input_email)
        btnSend = findViewById(R.id.btn_login)

        PassInput = findViewById(R.id.pass)
        ShowPass = findViewById(R.id.showpass)

//        LOGIN BUTTON
        btnSend.setOnClickListener {
            try {
                val Email = email.text.toString()
                val Pass = PassInput.text.toString()
                if (Email.isNotBlank() && Pass.isNotBlank()) {
                    val i = Intent(this, Activity_2::class.java)
                    i.putExtra(KEY_EMAIL, Email)
                    i.putExtra(KEY_PASS, Pass)
                    startActivity(i)
                } else {
                    Toast.makeText(applicationContext, "YOU NEED TO FILL YOUR EMAIL", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(applicationContext, "ERROR, TRY AGAIN!", Toast.LENGTH_SHORT).show()
            }
        }

//        CHECKBOX
        ShowPass.setOnClickListener {
            if (ShowPass.isChecked) {
                PassInput.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                PassInput.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }

    }
}