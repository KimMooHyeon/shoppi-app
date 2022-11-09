package com.remind.kmh.shoppi_android.ui.categorydetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.remind.kmh.shoppi_android.databinding.ItemCategoryTopSellingBinding
import com.remind.kmh.shoppi_android.model.Category
import com.remind.kmh.shoppi_android.ui.category.CategoryDiffCallback


class CategoryTopSellingItemAdapter :
    ListAdapter<Category, CategoryTopSellingItemAdapter.TopSellingItemViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopSellingItemViewHolder {
        val binding = ItemCategoryTopSellingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TopSellingItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopSellingItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TopSellingItemViewHolder(private val binding: ItemCategoryTopSellingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category) {
            binding.category = category
            binding.executePendingBindings()
        }
    }
}