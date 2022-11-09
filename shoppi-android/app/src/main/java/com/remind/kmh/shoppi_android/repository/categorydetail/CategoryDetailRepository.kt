package com.remind.kmh.shoppi_android.repository.categorydetail

import com.remind.kmh.shoppi_android.model.CategoryDetail

class CategoryDetailRepository(
    private val remoteDataSource: CategoryDetailRemoteDataSource
) {

    suspend fun getCategoryDetail(): CategoryDetail {
        return remoteDataSource.getCategoryDetail()
    }
}