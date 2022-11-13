package com.remind.kmh.shoppi_android.repository.home

import com.remind.kmh.shoppi_android.model.HomeData

class HomeRepository(
    private val assetDataSource: HomeAssetDataSource
) {
    fun getHomeData(): HomeData? {
        return assetDataSource.getHomeData()
    }
}