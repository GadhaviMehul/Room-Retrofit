package com.example.roomdatabasestore

import android.app.Application
import com.example.roomdatabasestore.api.ApiService
import com.example.roomdatabasestore.api.RetrofitHelper
import com.example.roomdatabasestore.db.QuoteDatabase
import com.example.roomdatabasestore.repository.Repository

class Application : Application() {

    lateinit var quoteRepository: Repository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val apiService = RetrofitHelper.getInstance().create(ApiService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = Repository(apiService, database, applicationContext)
    }
}