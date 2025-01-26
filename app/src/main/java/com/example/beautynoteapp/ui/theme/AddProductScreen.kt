package com.example.beautynoteapp.ui.theme

import androidx.activity.compose.LocalActivityResultRegistryOwner.current
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.beautynoteapp.R
import com.example.beautynoteapp.data.FullProductViewModel
import com.example.beautynoteapp.data.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreen(
    navigation: NavController,
    onProductAdded: (Product) -> Unit
) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.adder3),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
    val viewModel: FullProductViewModel = viewModel()

    var productName by remember { mutableStateOf("") }
    var brand by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf("") }
    var photo by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        ScreenTitle(
            title = "Add New Product",
            subtitle = "\"Makeup is art for the face.\""
        )
        OutlinedTextField(
            value = productName,
            onValueChange = { productName = it },
            label = { Text("Product Name") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xffc2185b),
                unfocusedBorderColor = Color(0xffc2185b),
                focusedLabelColor = Color(0xffc2185b),
                unfocusedLabelColor = Color(0xffc2185b),
                unfocusedTextColor = Color(0xffc2185b),
                focusedTextColor = Color(0xff616161)
            )
        )

        OutlinedTextField(
            value = brand,
            onValueChange = { brand = it },
            label = { Text("Brand") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xffc2185b),
                unfocusedBorderColor = Color(0xffc2185b),
                focusedLabelColor = Color(0xffc2185b),
                unfocusedLabelColor = Color(0xffc2185b),
                unfocusedTextColor = Color(0xffc2185b),
                focusedTextColor = Color(0xff616161)
            )
        )

        OutlinedTextField(
            value = type,
            onValueChange = { type = it },
            label = { Text("Type") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xffc2185b),
                unfocusedBorderColor = Color(0xffc2185b),
                focusedLabelColor = Color(0xffc2185b),
                unfocusedLabelColor = Color(0xffc2185b),
                unfocusedTextColor = Color(0xffc2185b),
                focusedTextColor = Color(0xff616161)
            )
        )

        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            label = { Text("Price") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xffc2185b),
                unfocusedBorderColor = Color(0xffc2185b),
                focusedLabelColor = Color(0xffc2185b),
                unfocusedLabelColor = Color(0xffc2185b),
                unfocusedTextColor = Color(0xffc2185b),
                focusedTextColor = Color(0xff616161)
            )
        )

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xffc2185b),
                unfocusedBorderColor = Color(0xffc2185b),
                focusedLabelColor = Color(0xffc2185b),
                unfocusedLabelColor = Color(0xffc2185b),
                unfocusedTextColor = Color(0xffc2185b),
                focusedTextColor = Color(0xff616161)
            )
        )

        OutlinedTextField(
            value = rating,
            onValueChange = { rating = it },
            label = { Text("Rating") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),

            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xffc2185b),
                unfocusedBorderColor = Color(0xffc2185b),
                focusedLabelColor = Color(0xffc2185b),
                unfocusedLabelColor = Color(0xffc2185b),
                unfocusedTextColor = Color(0xffc2185b),
                focusedTextColor = Color(0xff616161)
            )
        )

        OutlinedTextField(
            value = photo,
            onValueChange = { photo = it },
            label = { Text("Image URL") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xffc2185b),
                unfocusedBorderColor = Color(0xffc2185b),
                focusedLabelColor = Color(0xffc2185b),
                unfocusedLabelColor = Color(0xffc2185b),
                unfocusedTextColor = Color(0xffc2185b),
                focusedTextColor = Color(0xff616161)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (productName.isBlank() || brand.isBlank() || price.isBlank() || description.isBlank() || rating.isBlank()) {
                    return@Button
                }

                val priceValue = price.toDoubleOrNull()
                val ratingValue = rating.toFloatOrNull()

                if (priceValue == null || ratingValue == null || ratingValue < 0 || ratingValue > 5) {
                    return@Button
                }

                val newProduct = Product(
                    id = "${System.currentTimeMillis()}",
                    name = productName,
                    brand = brand,
                    type = type,
                    price = priceValue.toString(),
                    rating = ratingValue.toString(),
                    description = listOf(
                        com.example.beautynoteapp.data.Description(
                            fullName = description,
                            shade = "",
                            packaging = "",
                            purpose = "",
                            collection = ""
                        )
                    ),
                    isUsed = false
                )

                viewModel.addProduct(newProduct)
                onProductAdded(newProduct)
                navigation.popBackStack()
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color(0xffc2185b) // Corrected to use containerColor
            )
        ) {
            Text("Submit")
        }
    }
}



