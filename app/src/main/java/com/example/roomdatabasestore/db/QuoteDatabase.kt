package com.example.roomdatabasestore.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabasestore.model.Product
import com.example.roomdatabasestore.model.ProductItem
import com.example.roomdatabasestore.model.Result

@Database(entities = [ProductItem::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quoteDao() : QuoteDao


    companion object{
        @Volatile
        private var INSTANCE: QuoteDatabase? = null

        fun getDatabase(context: Context): QuoteDatabase {
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        QuoteDatabase::class.java,
                        "quoteDB")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}