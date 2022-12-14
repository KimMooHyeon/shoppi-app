package com.remind.kmh.shoppi_android.repository.category

import com.remind.kmh.shoppi_android.model.Categories

class CategoryRepository(private val remoteDataSource: CategoryRemoteDataSource) {

    suspend fun getCategories(): Categories {
        return remoteDataSource.getCategories()
    }
}