package com.example.ukllagi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var email: TextInputEditText
    private lateinit var btnSend: Button
    private lateinit var btnSignUp: TextView

    private lateinit var PassInput: TextInputEditText
    private lateinit var ShowPass: CheckBox

    private val KEY_EMAIL = "EA"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.input_email)
        btnSend = findViewById(R.id.btn_login)
        btnSignUp = findViewById(R.id.btn_signUp)

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
                    startActivity(i)
                } else {
                    Toast.makeText(applicationContext, "YOU NEED TO FILL YOUR EMAIL", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(applicationContext, "ERROR, TRY AGAIN!", Toast.LENGTH_SHORT).show()
            }
        }

        btnSignUp.setOnClickListener {
            try {
                val i = Intent(this, FragmentBar::class.java)
                startActivity(i)
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(applicationContext, "Cant Go To SignUp", Toast.LENGTH_SHORT).show()
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