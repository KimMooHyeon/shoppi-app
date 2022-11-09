package com.remind.kmh.shoppi_android.network


import com.remind.kmh.shoppi_android.model.Categories
import com.remind.kmh.shoppi_android.model.CategoryDetail
import com.remind.kmh.shoppi_android.model.Product
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("categories.json")
    suspend fun getCategories(): Categories
    @GET("fashion_female.json")
    suspend fun getCategoryDetail(): CategoryDetail

    @GET("products/{productId}.json")
    suspend fun getProductDetail(@Path("productId") productId: String): Product

    companion object {

        private const val baseUrl = "https://shoppi-4fb50-default-rtdb.asia-southeast1.firebasedatabase.app/"

        fun create(): ApiClient {

            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiClient::class.java)
        }
    }
}