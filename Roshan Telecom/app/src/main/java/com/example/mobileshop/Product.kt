package com.example.mobileshop

import java.io.Serializable

data class Product(
    val name: String,
    val price: Int,
    val imageUrl: String,
    val category: String,
    val rating: Float,
    val description: String = "No description available"
) : Serializable
