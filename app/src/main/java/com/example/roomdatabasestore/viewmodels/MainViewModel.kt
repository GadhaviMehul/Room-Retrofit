package com.example.roomdatabasestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabasestore.model.Product
import com.example.roomdatabasestore.model.ProductItem
import com.example.roomdatabasestore.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getProduct()
        }
    }

    val product : LiveData<MutableList<ProductItem>>
    get() = repository.product
}