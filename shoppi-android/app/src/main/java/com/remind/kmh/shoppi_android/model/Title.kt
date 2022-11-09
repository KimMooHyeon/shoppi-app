package com.remind.kmh.shoppi_android.model

import com.google.gson.annotations.SerializedName

data class Title(
    @SerializedName("icon_url") val iconUrl: String?,
    val text: String
)