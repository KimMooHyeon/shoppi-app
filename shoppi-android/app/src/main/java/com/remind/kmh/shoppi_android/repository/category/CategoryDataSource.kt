package com.remind.kmh.shoppi_android.repository.category

import com.remind.kmh.shoppi_android.model.Categories

interface CategoryDataSource {
    suspend fun getCategories(): Categories
}