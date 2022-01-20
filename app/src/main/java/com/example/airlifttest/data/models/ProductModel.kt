package com.example.airlifttest.data.models

import java.io.Serializable

class ProductModel : ArrayList<ProductModelItem>()

data class ProductModelItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
): Serializable

data class Rating(
    val count: Int,
    val rate: Double
): Serializable