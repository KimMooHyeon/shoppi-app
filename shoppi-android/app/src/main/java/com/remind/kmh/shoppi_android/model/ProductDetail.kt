package com.remind.kmh.shoppi_android.model

import com.google.gson.annotations.SerializedName

data class ProductDetail(
    @SerializedName("brand_name") val brandName: String,
    @SerializedName("discount_rate") val discountRate: Int,
    val label: String,
    val price: Int,
    @SerializedName("product_id") val productId: String,
    @SerializedName("thumbnail_image_url") val thumbnailImageUrl: String
)