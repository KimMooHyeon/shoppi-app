package com.remind.kmh.shoppi_android.ui.categorydetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.remind.kmh.shoppi_android.model.Promotion
import com.remind.kmh.shoppi_android.model.TopSelling
import com.remind.kmh.shoppi_android.repository.categorydetail.CategoryDetailRepository

import kotlinx.coroutines.launch

class CategoryDetailViewModel(
    private val categoryDetailRepository: CategoryDetailRepository
): ViewModel() {

    private val _topSelling = MutableLiveData<TopSelling>()
    val topSelling: LiveData<TopSelling> = _topSelling

    private val _promotions = MutableLiveData<Promotion>()
    val promotions: LiveData<Promotion> = _promotions

    init {
        loadCategoryDetail()
    }

    private fun loadCategoryDetail() {
        viewModelScope.launch {
            val categoryDetail = categoryDetailRepository.getCategoryDetail()
            _topSelling.value = categoryDetail.topSelling
            _promotions.value = categoryDetail.promotions
        }
    }
}