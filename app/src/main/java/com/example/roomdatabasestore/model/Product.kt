package com.example.roomdatabasestore.model

data class Product(
    var list : MutableList<ProductItem> ?= arrayListOf()
)