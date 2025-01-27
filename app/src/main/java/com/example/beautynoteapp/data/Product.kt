package com.example.beautynoteapp.data

data class Product(
    var id: Int,
    var image: String = "",
    var name: String = "",
    var brand: String = "",
    var description: List<Description> = listOf(),
    var type: String = "",
    var price: String = "",
    var rating: String = "",
    var isUsed: Boolean = false
)

data class Description(
    var fullName: String = "",
    var shade: String = "",
    var packaging: String = "",
    var purpose: String = "",
    var collection: String = "",
)