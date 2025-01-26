package com.example.beautynoteapp.data

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

data class ProductList(val name: String, val brand: String)

class ProductViewModel : ViewModel() {

    private val _productList = mutableStateListOf<ProductList>()
    val productList: List<ProductList> get() = _productList

    fun addProduct(name: String, brand: String) {
        if (name.isNotBlank() && brand.isNotBlank()) {
            _productList.add(ProductList(name, brand))
        }
    }

    fun deleteProduct(index: Int) {
        _productList.removeAt(index)
    }
}