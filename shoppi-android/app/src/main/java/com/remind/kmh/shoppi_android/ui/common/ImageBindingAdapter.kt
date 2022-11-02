package com.remind.kmh.shoppi_android.ui.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.remind.kmh.shoppi_android.GlideApp

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    GlideApp.with(view)
        .load(imageUrl)
        .into(view)
}