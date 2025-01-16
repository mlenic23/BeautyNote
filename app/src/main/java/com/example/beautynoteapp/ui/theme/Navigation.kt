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

    fun getProductDetailsPath(productId: Int): String {
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
            // Preuzimamo productId sa navArgument
            val productId = backStackEntry.arguments?.getInt("productId") ?: 0
            ProductDetailsScreen(
                navigation = navController,
                productId = productId // Prosleđujemo productId
            )
        }
    }
}