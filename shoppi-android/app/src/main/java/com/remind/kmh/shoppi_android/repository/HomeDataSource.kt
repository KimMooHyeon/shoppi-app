package com.remind.kmh.shoppi_android.repository

import com.remind.kmh.shoppi_android.model.HomeData

interface HomeDataSource {
    fun getHomeData(): HomeData?
}