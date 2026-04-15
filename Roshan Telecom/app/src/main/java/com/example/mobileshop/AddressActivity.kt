package com.example.mobileshop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class AddressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)

        val toolbar = findViewById<Toolbar>(R.id.toolbarAddress)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        val btnPlaceOrder = findViewById<Button>(R.id.btnContinue)
        val etFullName = findViewById<EditText>(R.id.etFullName)
        val etPhone = findViewById<EditText>(R.id.etPhone)

        btnPlaceOrder.setOnClickListener {
            val name = etFullName.text.toString()
            val phone = etPhone.text.toString()

            if (name.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show()
            } else {
                // Navigate to Order Confirmation
                val intent = Intent(this, OrderConfirmationActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
