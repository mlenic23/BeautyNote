package com.example.beautynoteapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.beautynoteapp.data.FullProductViewModel
import com.example.beautynoteapp.data.ProductViewModel
import com.example.beautynoteapp.ui.theme.AddProductForm
import com.example.beautynoteapp.ui.theme.BeautyNoteScreen
import com.example.beautynoteapp.ui.theme.ListScreen
import com.example.beautynoteapp.ui.theme.ProductDetailsScreen

object Routes {
    const val SCREEN_ALL_PRODUCTS = "productsList"
    const val SCREEN_PRODUCTS_DETAILS = "productDetails/{productId}"
    const val SCREEN_LIST = "List"
    const val SCREEN_ADD_PRODUCT = "addProductScreen"

    fun getProductDetailsPath(productId: Int?) : String {
        if (productId != null && productId != -1) {
            return "productDetails/$productId"
        }
        return "productDetails/0"
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
                viewModel = FullProductViewModel(),
                onButtonClick = { newIndex -> currentActiveButton = newIndex }
            )
        }
        composable(
            Routes.SCREEN_PRODUCTS_DETAILS,
            arguments = listOf(
                navArgument("productId") {
                    type = NavType.IntType
                }
            )
        ){backStackEntry -> backStackEntry.arguments?.getInt("stadiumId")?.let {
            ProductDetailsScreen(
                navigation = navController,
                productId = it,
                viewModel = FullProductViewModel()
            )
        } }

        composable(Routes.SCREEN_LIST) {
            ListScreen(
                navigation = navController,
                currentActiveButton = currentActiveButton,
                viewModel = viewModel,
                onButtonClick = { newIndex -> currentActiveButton = newIndex }
            )
        }
        composable(Routes.SCREEN_ADD_PRODUCT) {
            AddProductForm(
                navigation = navController,
                viewModel = FullProductViewModel(),
            )
        }
    }
}
