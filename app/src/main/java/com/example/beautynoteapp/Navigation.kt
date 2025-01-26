package com.example.beautynoteapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.beautynoteapp.data.ProductViewModel
import com.example.beautynoteapp.ui.theme.AddProductScreen
import com.example.beautynoteapp.ui.theme.BeautyNoteScreen
import com.example.beautynoteapp.ui.theme.ListScreen
import com.example.beautynoteapp.ui.theme.ProductDetailsScreen
import com.example.beautynoteapp.ui.theme.products

object Routes {
    const val SCREEN_ALL_PRODUCTS = "productsList"
    const val SCREEN_PRODUCTS_DETAILS = "productDetails/{productId}"
    const val SCREEN_LIST = "List"
    const val SCREEN_ADD_PRODUCT = "addProductScreen"

    fun getProductDetailsPath(productId: String): String {
        return "productDetails/$productId"
    }
}

@Composable
fun NavigationController(viewModel: ProductViewModel) {
    val navController = rememberNavController()
    var currentActiveButton by rememberSaveable { mutableStateOf(0) }

    NavHost(
        navController = navController,
        startDestination = Routes.SCREEN_ALL_PRODUCTS) {

        composable(Routes.SCREEN_ALL_PRODUCTS) {
            BeautyNoteScreen(
                navigation = navController,
                currentActiveButton = currentActiveButton,
                onButtonClick = { newIndex -> currentActiveButton = newIndex }
            )
        }
        composable(
            Routes.SCREEN_PRODUCTS_DETAILS,
            arguments = listOf(
                navArgument("productId") {
                    type  = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId") ?:0
            ProductDetailsScreen(
                navigation = navController,
                productId = productId.toString()
            )
        }

        composable(Routes.SCREEN_LIST) {
            ListScreen(
                navigation = navController,
                currentActiveButton = currentActiveButton,
                viewModel = viewModel,
                onButtonClick = { newIndex -> currentActiveButton = newIndex }
            )
        }

        composable(Routes.SCREEN_ADD_PRODUCT) {
            AddProductScreen(
                navigation = navController,
                onProductAdded = { newProduct ->
                    products.add(newProduct)
                }
            )
        }
    }
}
