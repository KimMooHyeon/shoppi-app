package com.remind.kmh.shoppi_android.model

import com.google.gson.annotations.SerializedName
import com.remind.kmh.shoppi_android.model.Banner
import com.remind.kmh.shoppi_android.model.Title


data class HomeData(
    val title: Title,
    @SerializedName("top_banners") val topBanners: List<Banner>
)