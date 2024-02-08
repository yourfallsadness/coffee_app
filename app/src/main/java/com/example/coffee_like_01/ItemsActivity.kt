package com.example.coffee_like_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val items_list: RecyclerView = findViewById(R.id.items_list)
        val items = arrayListOf<Item>()

        items.add(Item(1, "kap", "Капучино", "Классический кофейный напиток на основе эспрессо и взбитого молока.", "Состав напитка: эспрессо, молоко \n200 мл \nКкал 92 \nБелки, г 5 \nЖиры, г 5 \nУглеводы, г 8",150))
        items.add(Item(2, "latte", "Латте", "Молочный слоеный кофе. Взбитое молоко, насыщенный вкус эспрессо.", "Состав напитка: эспрессо, молоко \n200 мл \nКкал 92 \nБелки, г 5 \nЖиры, г 5 \nУглеводы, г 8",150))
        items.add(Item(3,"raf", "Раф", "Для любителей послаще, кофе на основе эспрессо с добавлением ванильного сахара/сиропа, молока и нежных сливок.", "Состав напитка: эспрессо, молоко, сливки, ванильный сахар \n350 мл \nЭнергетическая и пищевая ценность: \nКкал 243 \nБелки, г 7 \nЖиры, г 15 \nУглеводы, г 22",180))
        items.add(Item(4, "americano","Американо", "Черный кофе на основе эспрессо с добавлением горячей воды.","Состав напитка: эспрессо, вода \n200 мл \nЭнергетическая и пищевая ценность: \nКкал 0 \nБелки, г 0 \nЖиры, г 0 \nУглеводы, г 0", 120))
        items.add(Item(5, "espresso", "Эспрессо","Насыщенный черный кофе.", "Состав напитка: эспрессо \n60мл \nЭнергетическая и пищевая ценность: \nКкал 0 \nБелки, г 0 \nЖиры, г 0 \nУглеводы, г 0",100))

        items_list.layoutManager = LinearLayoutManager(this)
        items_list.adapter = ItemsAdapter(items, this)
    }
}