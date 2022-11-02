package com.remind.kmh.shoppi_android.repository

import com.google.gson.Gson
import com.remind.kmh.shoppi_android.AssetLoader
import com.remind.kmh.shoppi_android.model.HomeData

class HomeAssetDataSource(private val assetLoader: AssetLoader) : HomeDataSource {
    private val gson = Gson()
    override fun getHomeData(): HomeData? {
        return assetLoader.getJsonString("home.json")?.let { homeJsonString ->
            gson.fromJson(homeJsonString, HomeData::class.java)
        }
    }
}