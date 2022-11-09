package com.remind.kmh.shoppi_android.repository.categorydetail

import com.remind.kmh.shoppi_android.model.CategoryDetail

interface CategoryDetailDataSource {

    suspend fun getCategoryDetail(): CategoryDetail
}