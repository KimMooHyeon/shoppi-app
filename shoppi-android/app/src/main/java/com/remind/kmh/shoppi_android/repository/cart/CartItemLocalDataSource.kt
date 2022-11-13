package com.remind.kmh.shoppi_android.repository.cart

import com.remind.kmh.shoppi_android.database.CartItemDao
import com.remind.kmh.shoppi_android.model.CartItem

class CartItemLocalDataSource(
    private val dao: CartItemDao
) : CartItemDataSource {

    override suspend fun addCartItem(cartItem: CartItem) {
        dao.insert(cartItem)
    }

    override suspend fun getCartItems(): List<CartItem> {
        return dao.load()
    }
}