package com.example.beautynoteapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

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
fun NavigationController(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.SCREEN_ALL_PRODUCTS) {
        composable(Routes.SCREEN_ALL_PRODUCTS) {
            BeautyNoteScreen(navigation = navController)
        }
        composable(
            Routes.SCREEN_PRODUCTS_DETAILS,
            arguments = listOf(
                navArgument("productId") {
                    type = NavType.IntType // Prosljeđujemo productId kao Int
                }
            )
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId") ?: 0
            ProductDetailsScreen(
                navigation = navController,
                productId = productId
            )
        }

        composable(Routes.SCREEN_LIST) {
            ListScreen(navigation = navController)
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
