package com.example.roomdatabasestore.api

import com.example.roomdatabasestore.model.Product
import com.example.roomdatabasestore.model.ProductItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/products")
    suspend fun getProduct(): Response<MutableList<ProductItem>>

}