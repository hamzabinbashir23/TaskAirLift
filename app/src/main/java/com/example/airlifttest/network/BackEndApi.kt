package com.example.airlifttest.network

import com.example.airlifttest.data.models.ProductModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface BackEndApi {


    @Headers("accept: application/json")
    @GET("products")
    fun getProducts(): Call<ProductModel>
}