package com.example.mobileshop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OrderHistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_history)

        val toolbar = findViewById<Toolbar>(R.id.toolbarOrders)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        val rvOrders = findViewById<RecyclerView>(R.id.rvOrders)
        rvOrders.layoutManager = LinearLayoutManager(this)

        // Using only your added .png drawable resource names
        val orders = listOf(
            Product(
                name = "iPhone 15 Pro Max",
                price = 148900,
                imageUrl = "iphone",
                category = "Apple",
                rating = 4.9f,
                description = "Ordered on 12 Nov | Delivered"
            ),
            Product(
                name = "Samsung S24 Ultra",
                price = 129999,
                imageUrl = "samsung",
                category = "Samsung",
                rating = 4.9f,
                description = "Ordered on 10 Nov | Delivered"
            ),
            Product(
                name = "ASUS ROG Phone 9",
                price = 94999,
                imageUrl = "rog",
                category = "ASUS",
                rating = 4.9f,
                description = "Ordered on 08 Nov | Delivered"
            ),
            Product(
                name = "Vivo X100 Pro",
                price = 89999,
                imageUrl = "vivo4",
                category = "Vivo",
                rating = 4.8f,
                description = "Ordered on 05 Nov | Delivered"
            ),
            Product(
                name = "Realme GT 5G",
                price = 35999,
                imageUrl = "realme",
                category = "Realme",
                rating = 4.3f,
                description = "Ordered on 01 Nov | Delivered"
            ),
            Product(
                name = "Samsung Buds 2 Pro",
                price = 15999,
                imageUrl = "buds",
                category = "Earphone",
                rating = 4.7f,
                description = "Ordered on 28 Oct | Delivered"
            ),
            Product(
                name = "Apple AirPods Pro",
                price = 24900,
                imageUrl = "pods",
                category = "Earphone",
                rating = 4.8f,
                description = "Ordered on 25 Oct | Delivered"
            )
        )

        val adapter = ProductAdapter(orders) { }
        rvOrders.adapter = adapter
    }
}
