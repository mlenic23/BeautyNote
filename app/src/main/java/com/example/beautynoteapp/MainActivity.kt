package com.example.beautynoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.beautynoteapp.data.ProductViewModel
import com.example.beautynoteapp.ui.theme.BeautyNoteAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BeautyNoteAppTheme {
                val viewModel by viewModels<ProductViewModel>()
                NavigationController(viewModel)
            }
        }
    }
}

