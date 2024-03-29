package com.example.coffee_like_01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user_login: EditText = findViewById(R.id.user_login)
        val user_email: EditText = findViewById(R.id.user_email)
        val user_password: EditText = findViewById(R.id.user_password)
        val button: Button = findViewById(R.id.button_reg)
        val text_view_auth: TextView = findViewById(R.id.text_view_auth)

        text_view_auth.setOnClickListener{
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener{
            val login = user_login.text.toString().trim()
            val email = user_email.text.toString().trim()
            val password = user_password.text.toString().trim()

            if(login == "" || email == "" || password == "")
                Toast.makeText(this, "Введите данные", Toast.LENGTH_LONG).show()
            else {
                val user = User(login, email, password)

                val db = DbHelper(this, null)
                db.addUSer(user)
                Toast.makeText(this, "Пользователь $login добавлен", Toast.LENGTH_LONG).show()

                user_login.text.clear()
                user_email.text.clear()
                user_password.text.clear()

                val intent = Intent(this, ItemsActivity::class.java)
                startActivity(intent)
            }
        }

    }
}

