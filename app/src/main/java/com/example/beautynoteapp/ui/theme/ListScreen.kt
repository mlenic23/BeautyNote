package com.example.beautynoteapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController
import com.example.beautynoteapp.R
import com.example.beautynoteapp.data.ProductViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navigation: NavController,
    viewModel: ProductViewModel,
    currentActiveButton: Int,
    onButtonClick: (Int) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.back9),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }

    var newProductName by remember { mutableStateOf("") }
    var newProductBrand by remember { mutableStateOf("") }
    var isAddingProduct by remember { mutableStateOf(false) }

    fun addProduct(name: String, brand: String) {
        if (name.isNotBlank() && brand.isNotBlank()) {
            viewModel.addProduct(name, brand)
            newProductName = ""
            newProductBrand = ""
            isAddingProduct = false
        }
    }

    fun deleteProduct(index: Int) {
        viewModel.deleteProduct(index)
    }

    Column(modifier = Modifier.padding(16.dp)) {
        ChoiceButton(
            navController = navigation,
            currentActiveButton = currentActiveButton,
            onButtonClick = onButtonClick
        )

        ScreenTitle(
            title = "BeautyNote",
            subtitle = "\"Life is short, buy the makeup.\""
        )

        Spacer(modifier = Modifier.padding(top = 20.dp))

        LazyColumn() {
            itemsIndexed(viewModel.productList) { index, product ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(
                        text = "${product.name} - ${product.brand}",
                        modifier = Modifier.weight(1f),
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.DarkGray
                        )
                    )

                    CircularButton(
                        iconResource = R.drawable.x__1_,
                        color = Color(0xfff48fb1),
                        onClick = { deleteProduct(index) }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(modifier = Modifier.padding(start = 95.dp, top = 10.dp)) {
            IconButton(
                onClick = { isAddingProduct = true },
                iconResource = R.drawable.ic_plus,
                text = "Add new Product"
            )
        }

        val textFieldColors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.White,
            unfocusedTextColor = Color(0xffc51162),
            focusedTextColor = Color(0xffc51162),
            unfocusedLabelColor = Color(0xfff06292),
            focusedLabelColor = Color(0xffc51162),
            cursorColor = Color(0xfff06292)

        )

        if (isAddingProduct) {
            Column(modifier = Modifier.padding(16.dp)) {
                TextField(
                    value = newProductName,
                    onValueChange = { newProductName = it },
                    label = { Text("Product Name") },
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                    colors = textFieldColors
                )
                TextField(
                    value = newProductBrand,
                    onValueChange = { newProductBrand = it },
                    label = { Text("Product Brand") },
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                    colors = textFieldColors
                )
                CircularButton(
                    onClick = { addProduct(newProductName, newProductBrand) },
                    color = Color(0xffc51162),
                    iconResource = R.drawable.tick,
                )
            }
        }
    }
}















