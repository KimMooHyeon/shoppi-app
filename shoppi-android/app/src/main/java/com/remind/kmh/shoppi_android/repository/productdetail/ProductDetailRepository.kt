package com.remind.kmh.shoppi_android.repository.productdetail

import com.remind.kmh.shoppi_android.model.Product

class ProductDetailRepository(
    private val remoteDataSource: ProductDetailRemoteDataSource
) {

    suspend fun getProductDetail(productId:String): Product {
        return remoteDataSource.getProductDetail(productId)
    }
}