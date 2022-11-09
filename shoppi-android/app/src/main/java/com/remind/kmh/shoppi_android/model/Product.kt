package com.remind.kmh.shoppi_android.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("brand_name") val brandName: String?,
    @SerializedName("discount_rate") val discountRate: Int,
    val label: String,
    val price: Int,
    @SerializedName("product_id") val productId: String,
    @SerializedName("representative_image_url") val representativeImageUrl : String?,
    @SerializedName("thumbnail_image_url") val thumbnailImageUrl: String
)