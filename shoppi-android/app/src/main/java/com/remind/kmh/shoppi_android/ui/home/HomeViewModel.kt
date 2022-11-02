package com.remind.kmh.shoppi_android.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.remind.kmh.shoppi_android.model.Banner
import com.remind.kmh.shoppi_android.model.Title
import com.remind.kmh.shoppi_android.repository.HomeRepository

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {
    private val _title = MutableLiveData<Title>()
    val title: LiveData<Title> = _title

    private val _topBanners = MutableLiveData<List<Banner>>()
    val topBanners: LiveData<List<Banner>> = _topBanners

    init {
        loadHomeData()
    }

    private fun loadHomeData() {
        val homeData = homeRepository.getHomeData()
        homeData?.let { data ->
            _title.value = data.title
            _topBanners.value = data.topBanners
        }
    }
}