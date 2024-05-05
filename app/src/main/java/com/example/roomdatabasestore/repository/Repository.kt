package com.example.roomdatabasestore.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.roomdatabasestore.api.ApiService
import com.example.roomdatabasestore.db.QuoteDatabase
import com.example.roomdatabasestore.model.Product
import com.example.roomdatabasestore.model.ProductItem
import com.example.roomdatabasestore.utils.NetworkUtils

class Repository(
    private val apiService: ApiService,
    private val quoteDatabase: QuoteDatabase,
    private val applicationContext: Context,
) {

    private val productLiveData = MutableLiveData<MutableList<ProductItem>>()


    val product: LiveData<MutableList<ProductItem> >
        get() = productLiveData

    suspend fun getProduct() {

        if (NetworkUtils.isInternetAvailable(applicationContext)) {
            val result = apiService.getProduct()
            if (result.body() != null) {
                quoteDatabase.quoteDao().addProduct(result.body()!!)
               productLiveData.postValue(result.body())

            }
        } else {

            Log.i("test","product before")
            val productList : MutableList<ProductItem> = quoteDatabase.quoteDao().getProduct().toMutableList()


            Log.i("test","product ${productList.size}")
            productLiveData.postValue(productList)
        }
    }
}








