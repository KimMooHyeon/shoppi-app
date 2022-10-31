package com.remind.kmh.shoppi_android

import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("background_image_url") val backgroundImageUrl: String,
    val badge: Badge,
    val label: String,
    @SerializedName("product_detail") val productDetail: ProductDetail
)