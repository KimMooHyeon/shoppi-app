package com.remind.kmh.shoppi_android.ui.categorydetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.remind.kmh.shoppi_android.R
import com.remind.kmh.shoppi_android.common.KEY_CATEGORY_LABEL
import com.remind.kmh.shoppi_android.common.KEY_PRODUCT_ID
import com.remind.kmh.shoppi_android.databinding.FragmentCategoryDetailBinding
import com.remind.kmh.shoppi_android.ui.common.ProductClickListener
import com.remind.kmh.shoppi_android.ui.common.ProductPromotionAdapter
import com.remind.kmh.shoppi_android.ui.common.SectionTitleAdapter
import com.remind.kmh.shoppi_android.ui.common.ViewModelFactory


class CategoryDetailFragment: Fragment(), ProductClickListener {

    private lateinit var binding: FragmentCategoryDetailBinding
    private val viewModel: CategoryDetailViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        setToolbar()
        setListAdapter()
        setNavigation()
    }

    override fun onProductClick(productId: String) {
        findNavController().navigate(
            R.id.action_category_detail_to_product_detail, bundleOf(
            KEY_PRODUCT_ID to "desk-1"
        )
        )
    }

    private fun setToolbar() {
        val categoryLabel = requireArguments().getString(KEY_CATEGORY_LABEL)
        binding.toolbarCategoryDetail.title = categoryLabel
    }
    private fun setNavigation() {
        binding.toolbarCategoryDetail.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }
    private fun setListAdapter() {
        val topSellingSectionAdapter = CategoryTopSellingSectionAdapter()
        val titleAdapter = SectionTitleAdapter()
        val promotionAdapter = ProductPromotionAdapter(this)
        binding.rvCategoryDetail.adapter = ConcatAdapter(topSellingSectionAdapter, titleAdapter, promotionAdapter)
        viewModel.topSelling.observe(viewLifecycleOwner) { topSelling ->
            topSellingSectionAdapter.submitList(listOf(topSelling))
        }
        viewModel.promotions.observe(viewLifecycleOwner) { promotions ->
            titleAdapter.submitList(listOf(promotions.title))
            promotionAdapter.submitList(promotions.items)
        }
    }
}
