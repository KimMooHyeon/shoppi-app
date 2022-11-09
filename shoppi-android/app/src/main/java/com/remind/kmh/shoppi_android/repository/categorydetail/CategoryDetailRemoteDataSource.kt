package com.remind.kmh.shoppi_android.repository.categorydetail

import com.remind.kmh.shoppi_android.model.CategoryDetail
import com.remind.kmh.shoppi_android.network.ApiClient

class CategoryDetailRemoteDataSource(private val api: ApiClient) : CategoryDetailDataSource {

    override suspend fun getCategoryDetail(): CategoryDetail {
        return api.getCategoryDetail()
    }
}