package com.remind.kmh.shoppi_android.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.remind.kmh.shoppi_android.model.CartItem

@Dao
interface CartItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(cartItem: CartItem)

    @Query("SELECT * FROM cart_item")
     fun load(): List<CartItem>
}