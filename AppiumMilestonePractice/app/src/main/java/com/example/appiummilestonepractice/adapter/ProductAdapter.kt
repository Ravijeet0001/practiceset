package com.example.appiummilestonepractice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appiummilestonepractice.R
import com.example.appiummilestonepractice.model.Product


class ProductAdapter(private val productList: List<Product>,private val onItemClick: (Product) ->Unit): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductAdapter.ProductViewHolder, position: Int) {
        val product=productList[position]
        holder.name.text = product.name
        holder.title.text = product.title
        holder.itemView.setOnClickListener{
            onItemClick(product)
        }
    }
    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

            val name : TextView = itemView.findViewById(R.id.text1)
            val title : TextView = itemView.findViewById(R.id.text2)


    }


}