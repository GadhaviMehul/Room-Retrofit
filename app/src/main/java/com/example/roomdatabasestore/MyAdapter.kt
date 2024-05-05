package com.example.roomdatabasestore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.roomdatabasestore.model.ProductItem
import com.example.roomdatabasestore.model.Result

class MyAdapter constructor(
    val context: Context,
    val arrayList: MutableList<ProductItem>
) : RecyclerView.Adapter<MyAdapter.PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_row, parent, false)
        return PostViewHolder(view)

    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.textView.text = "${arrayList.get(position).title}"
        Glide.with(context).load(arrayList.get(position).image).into(holder.imageView)


    }

    override fun getItemCount(): Int = arrayList.size


    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textviewresp)
        val imageView: ImageView = itemView.findViewById(R.id.imageviewpresp)

    }
}