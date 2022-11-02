package com.remind.kmh.shoppi_android.model

import com.google.gson.annotations.SerializedName

data class Badge(
    @SerializedName("background_color") val backgroundColor: String,
    val label: String
)