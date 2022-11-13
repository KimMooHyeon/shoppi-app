package com.remind.kmh.shoppi_android.ui.category

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.remind.kmh.shoppi_android.model.Categories
import com.remind.kmh.shoppi_android.model.Category
import com.remind.kmh.shoppi_android.repository.CategoryRepository
import com.remind.kmh.shoppi_android.ui.common.Event
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {

    private val _items = MutableLiveData<Categories>()
    val items: LiveData<Categories> = _items

    private val _openCategoryEvent = MutableLiveData<Event<Category>>()
    val openCategoryEvent: LiveData<Event<Category>> = _openCategoryEvent


    init {
        loadCategory()
    }

    fun openCategoryDetail(category: Category) {
        _openCategoryEvent.value = Event(category)
    }

    private fun loadCategory() {
        viewModelScope.launch {
            val categories = categoryRepository.getCategories()
            Log.d("CategoryFragment", categories.toString())
            _items.value = categories
        }
    }
}