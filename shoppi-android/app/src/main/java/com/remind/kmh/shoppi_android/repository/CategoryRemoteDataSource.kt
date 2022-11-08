package com.remind.kmh.shoppi_android.repository

import com.remind.kmh.shoppi_android.model.Categories
import com.remind.kmh.shoppi_android.network.ApiClient

class CategoryRemoteDataSource(private val apiClient: ApiClient) : CategoryDataSource {
    override suspend fun getCategories(): Categories {
        return apiClient.getCategories()
    }
}