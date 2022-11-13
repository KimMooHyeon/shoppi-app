package com.remind.kmh.shoppi_android.repository.productdetail

import com.remind.kmh.shoppi_android.model.Product


interface ProductDetailDataSource {

    suspend fun getProductDetail(productId:String): Product
}