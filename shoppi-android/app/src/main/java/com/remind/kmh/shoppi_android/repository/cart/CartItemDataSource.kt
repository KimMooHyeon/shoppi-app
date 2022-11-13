package com.remind.kmh.shoppi_android.repository.cart

import com.remind.kmh.shoppi_android.model.CartItem


interface CartItemDataSource {

    suspend fun addCartItem(cartItem: CartItem)

    suspend fun getCartItems(): List<CartItem>
}