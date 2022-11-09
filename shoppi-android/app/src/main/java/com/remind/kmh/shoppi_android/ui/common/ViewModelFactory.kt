package com.remind.kmh.shoppi_android.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.remind.kmh.shoppi_android.AssetLoader
import com.remind.kmh.shoppi_android.ServiceLocator
import com.remind.kmh.shoppi_android.network.ApiClient
import com.remind.kmh.shoppi_android.repository.CategoryRemoteDataSource
import com.remind.kmh.shoppi_android.repository.CategoryRepository
import com.remind.kmh.shoppi_android.repository.HomeAssetDataSource
import com.remind.kmh.shoppi_android.repository.HomeRepository
import com.remind.kmh.shoppi_android.repository.categorydetail.CategoryDetailRemoteDataSource
import com.remind.kmh.shoppi_android.repository.categorydetail.CategoryDetailRepository
import com.remind.kmh.shoppi_android.ui.category.CategoryViewModel
import com.remind.kmh.shoppi_android.ui.categorydetail.CategoryDetailViewModel
import com.remind.kmh.shoppi_android.ui.home.HomeViewModel

class ViewModelFactory(private val context: Context): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
                HomeViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                val repository = CategoryRepository(CategoryRemoteDataSource(ServiceLocator.provideApiClient()))
                CategoryViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CategoryDetailViewModel::class.java) -> {
                val repository = CategoryDetailRepository(CategoryDetailRemoteDataSource(
                    ServiceLocator.provideApiClient()))
                CategoryDetailViewModel(repository) as T
            }

            else -> {
                throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}