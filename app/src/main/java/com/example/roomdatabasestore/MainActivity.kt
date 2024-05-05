package com.example.roomdatabasestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabasestore.model.Product
import com.example.roomdatabasestore.model.ProductItem
import com.example.roomdatabasestore.viewmodels.MainViewModel
import com.example.roomdatabasestore.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    lateinit var MyAdapter:MyAdapter
    lateinit var RecyclerView: RecyclerView
    //var arrayList = MutableList<ProductItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        RecyclerView = findViewById(R.id.recyclerview)
        val repository = (application as Application).quoteRepository

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.product.observe(this, Observer {
            Toast.makeText(this@MainActivity, it.toString(), Toast.LENGTH_SHORT).show()
        })

        mainViewModel.product.observe(this) {
          //  arrayList = it.list
            RecyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            MyAdapter = MyAdapter(this@MainActivity, it)
            RecyclerView.adapter = MyAdapter
        }

    }
}