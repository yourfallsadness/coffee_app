package com.example.coffee_like_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.coffee_like_01.Session.LoginPref

class AuthActivity : AppCompatActivity() {

    private lateinit var user_login_auth: EditText
    private lateinit var user_password_auth: EditText
    private lateinit var button_reg_auth: Button

    lateinit var session: LoginPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        if (session.isAuth()){
            var i : Intent = Intent(applicationContext, ItemsActivity::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
            finish()
        }

        val text_view_reg: TextView = findViewById(R.id.text_view_reg)
        val user_login: EditText = findViewById(R.id.user_login_auth)
        val user_password: EditText = findViewById(R.id.user_password_auth)
        val button: Button = findViewById(R.id.button_reg_auth)

        text_view_reg.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener{
            val login = user_login.text.toString().trim()
            val password = user_password.text.toString().trim()

            if(login == "" || password == "")
                Toast.makeText(this, "Введите данные", Toast.LENGTH_LONG).show()
            else {
                val db = DbHelper(this,null)
               val isAuth = db.getUser(login, password)

                if(isAuth) {
                    Toast.makeText(this, "Вы вошли в аккаунт", Toast.LENGTH_LONG).show()

                    user_login.text.clear()
                    user_password.text.clear()

                    val intent = Intent(this, ItemsActivity::class.java)
                    startActivity(intent)

                } else
                    Toast.makeText(this, "Проверьте данные", Toast.LENGTH_LONG).show()

            }
        }
    }
}

