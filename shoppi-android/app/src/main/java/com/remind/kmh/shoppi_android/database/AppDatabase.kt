package com.remind.kmh.shoppi_android.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.remind.kmh.shoppi_android.model.CartItem

@Database(entities = [CartItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cartItemDao(): CartItemDao
}