package com.example.roomdatabasestore.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomdatabasestore.model.Product
import com.example.roomdatabasestore.model.ProductItem
import com.example.roomdatabasestore.model.Result

@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(quotes: List<ProductItem>)

    @Query("SELECT * FROM product")
    suspend fun getProduct() : List<ProductItem>

    //For Product


}