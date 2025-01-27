package com.example.beautynoteapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import com.example.beautynoteapp.data.Description
import com.example.beautynoteapp.data.FullProductViewModel
import com.example.beautynoteapp.data.Product


@Composable
fun ProductTypeButtons(
    selectedType: String,
    onTypeSelected: (String) -> Unit
) {
    val productTypes = listOf("Face", "Brows", "Lips", "Eyes")

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth(),
    ) {
        productTypes.forEach { type ->
            Button(
                onClick = { onTypeSelected(type) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedType == type) Color(0xffc51162) else Color.White,
                    contentColor = if (selectedType == type) Color.White else Color(0xffc51162)
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
            ) {
                Text(text = type)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductForm(
    navigation: NavController,
    viewModel: FullProductViewModel,
) {

    val scrollState = rememberScrollState()

    var name by remember { mutableStateOf("") }
    var image by remember { mutableStateOf("") }
    var brand by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf("") }
    var isUsed by remember { mutableStateOf(false) }
    var fullName by remember { mutableStateOf("") }
    var shade by remember { mutableStateOf("") }
    var packaging by remember { mutableStateOf("") }
    var purpose by remember { mutableStateOf("") }
    var collection by remember { mutableStateOf("") }

    val products = viewModel.products

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


    Box(modifier = Modifier.fillMaxSize()){

        Image(
            painter = painterResource(id = R.drawable.adder3),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)

        ){
            ScreenTitle(title="BeautyNote", subtitle = "\"Makeup is face art.\"")

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                Text("Used", style = TextStyle(Color(0xffc51162), fontSize = 20.sp, fontWeight = FontWeight.Bold))
                Checkbox(checked = isUsed, onCheckedChange = { isUsed = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xffc51162),
                        checkmarkColor = Color.White ))
            }

            Spacer(modifier = Modifier.height(16.dp))

            ProductTypeButtons(
                selectedType = type,
                onTypeSelected = { type = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Product Name") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                colors = textFieldColors
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = image,
                onValueChange = { image = it },
                label = { Text("Image URL") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                colors = textFieldColors
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = brand,
                onValueChange = { brand = it },
                label = { Text("Brand") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                colors = textFieldColors
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = price,
                onValueChange = { price = it },
                label = { Text("Price") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                colors = textFieldColors
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = rating,
                onValueChange = { rating = it },
                label = { Text("Rating") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                colors = textFieldColors
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = fullName,
                onValueChange = { fullName = it },
                label = { Text("Full Name") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                colors = textFieldColors
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = shade,
                onValueChange = { shade = it },
                label = { Text("Shade") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                colors = textFieldColors
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = packaging,
                onValueChange = { packaging = it },
                label = { Text("Packaging") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                colors = textFieldColors
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = purpose,
                onValueChange = { purpose = it },
                label = { Text("Purpose") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                colors = textFieldColors

            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = collection,
                onValueChange = { collection = it },
                label = { Text("Collection") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                colors = textFieldColors
            )

            Spacer(modifier = Modifier.height(16.dp))


            Button(
                onClick = {
                    if (name.isNotEmpty() && image.isNotEmpty() && brand.isNotEmpty()){
                    val newProduct = Product(
                        id = products.size,
                        name = name,
                        image = image,
                        brand = brand,
                        type = type,
                        price = price,
                        rating = rating,
                        isUsed = isUsed,
                        description = listOf(
                            Description(
                                fullName = fullName,
                                shade = shade,
                                packaging = packaging,
                                purpose = purpose,
                                collection = collection
                            )
                        )
                    )
                    viewModel.addProduct(newProduct)
                    navigation.popBackStack()
                }},

                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 30.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xffc51162))
            ) {
                Text(text = "Submit", color = Color.White)
            }
        }
    }
}


