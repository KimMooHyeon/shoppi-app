package com.remind.kmh.shoppi_android.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.remind.kmh.shoppi_android.repository.category.CategoryRemoteDataSource
import com.remind.kmh.shoppi_android.repository.category.CategoryRepository
import com.remind.kmh.shoppi_android.repository.home.HomeAssetDataSource
import com.remind.kmh.shoppi_android.repository.home.HomeRepository
import com.remind.kmh.shoppi_android.repository.categorydetail.CategoryDetailRemoteDataSource
import com.remind.kmh.shoppi_android.repository.categorydetail.CategoryDetailRepository
import com.remind.kmh.shoppi_android.repository.productdetail.ProductDetailRemoteDataSource
import com.remind.kmh.shoppi_android.repository.productdetail.ProductDetailRepository
import com.remind.kmh.shoppi_android.ui.cart.CartViewModel
import com.remind.kmh.shoppi_android.ui.category.CategoryViewModel
import com.remind.kmh.shoppi_android.ui.categorydetail.CategoryDetailViewModel
import com.remind.kmh.shoppi_android.ui.home.HomeViewModel
import com.remind.kmh.shoppi_android.ui.productdetail.ProductDetailViewModel

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
            modelClass.isAssignableFrom(ProductDetailViewModel::class.java) -> {
                val repository = ProductDetailRepository(ProductDetailRemoteDataSource(
                    ServiceLocator.provideApiClient()))
                ProductDetailViewModel(repository, ServiceLocator.provideCartRepository(context)) as T
            }
            modelClass.isAssignableFrom(CartViewModel::class.java) -> {
                CartViewModel(ServiceLocator.provideCartRepository(context)) as T
            }
            else -> {
                throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}