package com.example.mobileshop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        val name = intent.getStringExtra("product_name")
        val price = intent.getIntExtra("product_price", 0)
        val imageUrl = intent.getStringExtra("product_image") ?: ""
        val rating = intent.getFloatExtra("product_rating", 0f)
        val description = intent.getStringExtra("product_description") ?: "Premium quality smartphone with advanced features."

        if (name != null) {
            supportActionBar?.title = name
            
            val ivDetailMobile = findViewById<ImageView>(R.id.ivDetailMobile)
            val tvDetailName = findViewById<TextView>(R.id.tvDetailName)
            val tvDetailRating = findViewById<TextView>(R.id.tvDetailRating)
            val tvDetailPrice = findViewById<TextView>(R.id.tvDetailPrice)
            val tvDetailDescription = findViewById<TextView>(R.id.tvDetailDescription)
            val btnBuyNow = findViewById<Button>(R.id.btnBuyNow)
            val btnAddToCart = findViewById<Button>(R.id.btnAddToCart)

            tvDetailName.text = name
            tvDetailRating.text = "$rating ★"
            tvDetailPrice.text = "₹$price"
            tvDetailDescription.text = description

            // Image loading logic for both URL and local drawable
            val resId = resources.getIdentifier(imageUrl, "drawable", packageName)
            if (resId != 0) {
                ivDetailMobile.setImageResource(resId)
            } else {
                Glide.with(this)
                    .load(imageUrl)
                    .placeholder(android.R.drawable.ic_menu_gallery)
                    .error(android.R.drawable.stat_notify_error)
                    .into(ivDetailMobile)
            }

            btnBuyNow.setOnClickListener {
                val intent = Intent(this, AddressActivity::class.java)
                startActivity(intent)
            }
            
            btnAddToCart.setOnClickListener {
                finish() // Simplified for now
            }
        }
    }
}