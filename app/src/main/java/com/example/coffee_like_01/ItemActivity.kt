package com.example.coffee_like_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val title: TextView = findViewById(R.id.item_title_one)
        val text: TextView = findViewById(R.id.item_text)
        val buy_button: Button = findViewById(R.id.buy_button)

        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")

        buy_button.setOnClickListener{
            val intent = Intent(this, GoodsActivity::class.java)
            startActivity(intent)
        }
    }
}