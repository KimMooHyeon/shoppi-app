package com.remind.kmh.shoppi_android.ui.category

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.remind.kmh.shoppi_android.model.Categories
import com.remind.kmh.shoppi_android.repository.CategoryRepository
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {

    private val _items = MutableLiveData<Categories>()
    val items: LiveData<Categories> = _items

    init {
        Log.d("CategoryFragment","start")
        loadCategory()
    }

    private fun loadCategory() {
        viewModelScope.launch {
            val categories = categoryRepository.getCategories()
            Log.d("CategoryFragment",categories.toString())
            _items.value = categories
        }
    }
}