package com.remind.kmh.shoppi_android.repository.productdetail

import com.remind.kmh.shoppi_android.model.CategoryDetail
import com.remind.kmh.shoppi_android.model.Product
import com.remind.kmh.shoppi_android.network.ApiClient

class ProductDetailRemoteDataSource(private val api: ApiClient) : ProductDetailDataSource {

    override suspend fun getProductDetail(productId:String): Product {
        return api.getProductDetail(productId)
    }
}