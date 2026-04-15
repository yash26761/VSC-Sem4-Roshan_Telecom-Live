package com.example.mobileshop

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var rvStillLooking: RecyclerView
    private lateinit var rvMobiles: RecyclerView
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var ivBanner: ImageView
    private lateinit var ivHistory: ImageView
    private lateinit var ivCart: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvStillLooking = findViewById(R.id.rvStillLooking)
        rvMobiles = findViewById(R.id.rvMobiles)
        bottomNav = findViewById(R.id.bottomNav)
        ivBanner = findViewById(R.id.ivBanner)
        ivHistory = findViewById(R.id.ivHistory)
        ivCart = findViewById(R.id.ivCart)

        // Modern Banner
        Glide.with(this)
            .load("https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?q=80&w=1000&auto=format&fit=crop")
            .placeholder(android.R.drawable.ic_menu_gallery)
            .into(ivBanner)

        ivHistory.setOnClickListener {
            startActivity(Intent(this, OrderHistoryActivity::class.java))
        }

        ivCart.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

        setupStillLookingRecyclerView()
        setupMobilesRecyclerView()
        setupBottomNavigation()
    }

    private fun setupStillLookingRecyclerView() {
        // Using only your added .png drawable resources (filenames only)
        val list = listOf(
            Product("iPhone 15 Pro Max", 148900, "iphone", "Apple", 4.9f, "Natural Titanium, A17 Pro"),
            Product("Samsung S24 Ultra", 129999, "samsung", "Samsung", 4.9f, "Titanium Gray, Galaxy AI"),
            Product("ASUS ROG Phone 9", 94999, "rog", "ASUS", 4.9f, "Ultimate Gaming Beast")
        )
        rvStillLooking.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvStillLooking.adapter = ProductAdapter(list) { product -> openDetail(product) }
    }

    private fun setupMobilesRecyclerView() {
        val list = listOf(
            Product("iPhone 14 Plus", 79900, "iphone1", "Apple", 4.7f, "Big Screen, Long Battery"),
            Product("Vivo X100 Pro", 89999, "vivo4", "Vivo", 4.8f, "Zeiss Professional Optics"),
            Product("Realme GT 5G", 35999, "realme", "Realme", 4.3f, "Speed Inspired Design"),
            Product("Samsung Galaxy A54", 32999, "samsung1", "Samsung", 4.4f, "Premium Design"),
            Product("iPhone 13", 52900, "iphone3", "Apple", 4.6f, "Advanced Dual-camera"),
            Product("ASUS ROG 8", 84999, "rog3", "ASUS", 4.8f, "Gaming Performance"),
            Product("Realme 12 Pro", 29999, "realme1", "Realme", 4.4f, "Portrait Master")
        )
        rvMobiles.layoutManager = LinearLayoutManager(this)
        rvMobiles.adapter = ProductAdapter(list) { product -> openDetail(product) }
    }

    private fun openDetail(product: Product) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("product_name", product.name)
        intent.putExtra("product_price", product.price)
        intent.putExtra("product_image", product.imageUrl)
        intent.putExtra("product_rating", product.rating)
        startActivity(intent)
    }

    private fun setupBottomNavigation() {
        bottomNav.selectedItemId = R.id.nav_home
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_account -> {
                    startActivity(Intent(this, OrderHistoryActivity::class.java))
                    true
                }
                R.id.nav_cart -> {
                    startActivity(Intent(this, CartActivity::class.java))
                    true
                }
                else -> true
            }
        }
    }
}