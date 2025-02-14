package com.example.appiummilestonepractice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
         val username=findViewById<EditText>(R.id.user_name)
        val password=findViewById<EditText>(R.id.password)
        val lgnbtn=findViewById<Button>(R.id.loginbutton)
        val text=findViewById<TextView>(R.id.text1)

        lgnbtn.setOnClickListener{
            val inputUsername = username.text.toString()
            val inputPassword = password.text.toString()

            if (inputUsername == "ravi" && inputPassword == "ravi") {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, SecondActivity::class.java))
            } else {
                Toast.makeText(this, "Invalid Credentials!", Toast.LENGTH_SHORT).show()
            }
        }
        text.setOnClickListener{
            //pending
        }


    }
}