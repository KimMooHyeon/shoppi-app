package com.remind.kmh.shoppi_android.ui.category

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.remind.kmh.shoppi_android.R
import com.remind.kmh.shoppi_android.common.KEY_CATEGORY_ID
import com.remind.kmh.shoppi_android.common.KEY_CATEGORY_LABEL
import com.remind.kmh.shoppi_android.databinding.FragmentCategoryBinding
import com.remind.kmh.shoppi_android.model.Category
import com.remind.kmh.shoppi_android.ui.common.EventObserver
import com.remind.kmh.shoppi_android.ui.common.ViewModelFactory

class CategoryFragment: Fragment() {

    private val viewModel: CategoryViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: FragmentCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("openCategoryDetail","onCreate 실행")
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        Log.d("openCategoryDetail","onCreateView 실행")
        setNavigation()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        setListAdapter()

    }

    private fun setListAdapter() {
        val categoryAdapter = CategoryAdapter(viewModel)
        binding.rvCategoryList.adapter = categoryAdapter
        viewModel.items.observe(viewLifecycleOwner) {
            categoryAdapter.submitList(it)
        }
    }

    private fun setNavigation() {
        viewModel.openCategoryEvent.observe(viewLifecycleOwner, EventObserver {
            openCategoryDetail(it.categoryId, it.label)
        })
    }

    private fun openCategoryDetail(categoryId: String, categoryLabel: String) {
        Log.d("openCategoryDetail","openCategoryDetail 실행")
        findNavController().navigate(R.id.action_category_to_category_detail, bundleOf(
            KEY_CATEGORY_ID to categoryId,
            KEY_CATEGORY_LABEL to categoryLabel
        ))
    }

    override fun onStop() {
        Log.d("openCategoryDetail","onStop 실행")
        super.onStop()
    }
    override fun onDestroy() {
        Log.d("openCategoryDetail","onDestroy 실행")
        super.onDestroy()
    }
}