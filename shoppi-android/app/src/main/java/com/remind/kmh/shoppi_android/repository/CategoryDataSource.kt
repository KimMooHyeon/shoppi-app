package com.remind.kmh.shoppi_android.repository

import com.remind.kmh.shoppi_android.model.Categories

interface CategoryDataSource {
    suspend fun getCategories(): Categories
}