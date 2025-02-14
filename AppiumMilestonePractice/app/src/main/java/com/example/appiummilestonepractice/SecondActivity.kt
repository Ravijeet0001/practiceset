package com.example.appiummilestonepractice

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appiummilestonepractice.adapter.ProductAdapter
import com.example.appiummilestonepractice.model.Product

class SecondActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val recyclerView = findViewById<RecyclerView>(R.id.recycleview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val productList = listOf(
            Product(1, "Product 1",  "This is product 1 title","one"),
            Product(2, "Product 2",  "This is product 2 description","two")
        )
        recyclerView.adapter = ProductAdapter(productList) { product ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("PRODUCT_DESCRIPTION", product.description)
            }
            startActivity(intent)
        }


    }
}