package com.example.mobileshop

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val toolbar = findViewById<Toolbar>(R.id.toolbarCart)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        val rvCart = findViewById<RecyclerView>(R.id.rvCart)
        val tvTotalAmount = findViewById<TextView>(R.id.tvTotalAmount)
        val btnCheckout = findViewById<MaterialButton>(R.id.btnCheckout)

        rvCart.layoutManager = LinearLayoutManager(this)

        // Mock cart data using your drawable resources
        val cartItems = listOf(
            Product("iPhone 15 Pro Max", 148900, "iphone", "Apple", 4.9f, "Natural Titanium"),
            Product("Samsung Buds 2 Pro", 15999, "buds", "Earphone", 4.7f, "Graphite")
        )

        val total = cartItems.sumOf { it.price }
        tvTotalAmount.text = "₹$total"

        val adapter = ProductAdapter(cartItems) { }
        rvCart.adapter = adapter

        btnCheckout.setOnClickListener {
            val intent = Intent(this, AddressActivity::class.java)
            startActivity(intent)
        }
    }
}
