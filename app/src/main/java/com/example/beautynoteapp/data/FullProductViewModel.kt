package com.example.beautynoteapp.data

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class FullProductViewModel : ViewModel() {

    private val _productList = mutableStateListOf<Product>()
    val productList: List<Product> get() = _productList

    fun addProduct(product: Product) {
        _productList.add(product)
    }

}
