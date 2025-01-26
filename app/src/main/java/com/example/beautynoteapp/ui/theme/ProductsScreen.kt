@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.beautynoteapp.ui.theme

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.beautynoteapp.R
import com.example.beautynoteapp.Routes
import coil.compose.rememberAsyncImagePainter
import com.example.beautynoteapp.data.Product

var products: MutableList<Product> = mutableListOf(
    Product(
        id = "0",
        image = "https://www.lijepa.hr/data/cache/thumb_min500_max1000-min500_max1000-12/products/339187/1683200741/vichy-liftactiv-flexiteint-spf20-puder-za-zene-30-ml-odstin-15-opal-283254.jpg",
        name = "Powder",
        brand = "Vichy",
        description = listOf(
            com.example.beautynoteapp.data.Description(
                fullName = "Vichy liftactiv flexiteint anti-wrinkle liquid powder",
                shade = "45 gold",
                packaging = "30ml",
                purpose = "Liquid anti-wrinkle powder with a tightening silicone texture for an immediate lifting effect and a healthy skin glow without stiffening facial features.",
                collection = "Vichy lifeactiv"
            )

        ),
        type = "Face",
        price = "30€",
        rating = "4",
        isUsed = false,
    ),

    Product(
        id = "1",
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2IM1KHa8f7G5HWwX1Iozr-gX4sixf2aFXCA&s",
        name = "Mascara",
        brand = "Maybelline",
        description = listOf(
            com.example.beautynoteapp.data.Description(
                fullName = "Lash Sensational Mascara Firework",
                shade = "Black",
                packaging = "10ml",
                purpose = "Mascara for defined eyelashes full of volume, without lumps",
                collection = "Lash Sensational"
            )

        ),
        type = "Eyes",
        price = "21€",
        rating = "5",
        isUsed = false,

    ),

    Product(
        id = "2",
        image = "https://www.bnedutyfree.com.au/media/catalog/product/cache/e6410293f9a24f502cd707ec5c46309d/7/d/7dee3a48-e070-4d61-b583-c76a958b22d5.jpeg",
        name = "Lipstick",
        brand = "Mac",
        description = listOf(
            com.example.beautynoteapp.data.Description(
                fullName = "MACximal Silky Matte Lipstick",
                shade = "Mehr",
                packaging = "3.5ml",
                purpose = "Lipstick provides rich, long-lasting color for up to 12 hours nourishes and hydrates thanks to its nourishing composition provides full color coverage with a matte finish.",
                collection = "MAC Powder Kiss"
            )

        ),
        type = "Lips",
        price = "20€",
        rating = "3",
        isUsed = false,

    ),

    Product(
        id = "3",
        image = "https://www.trekpleister.nl/medias/sys_master/prd-images/h0e/h41/30121210118174/prd-front-3316461-1_600x600/prd-front-3316461-1-600x600.jpg",
        name = "Brow gel",
        brand = "Essence",
        description = listOf(
            com.example.beautynoteapp.data.Description(
                fullName = "Make Me Brow Eyebrow Gel Mascara",
                shade = "04 Ashy Brows",
                packaging = "3.8ml",
                purpose = "Colored eyebrow gel with fine fibers that fills, shapes and gives a natural look to the eyebrows.",
                collection = "Essence Make Me Brow"
            )

        ),
        type = "Brows",
        price = "3€",
        rating = "2",
        isUsed = false,

        )

)


@Composable
fun BeautyNoteScreen(navigation: NavController,currentActiveButton: Int, onButtonClick: (Int) -> Unit) {

    var productsList by remember { mutableStateOf(products.toMutableList()) }
    var selectedType by remember { mutableStateOf("Face") }
    var searchQuery by remember { mutableStateOf("") }

    LazyColumn(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xfffce4ec), Color(0xffc2185b))
                )
            )
    ) {
        item {
            ChoiceButton(navController = navigation,
                currentActiveButton = currentActiveButton,
                onButtonClick = onButtonClick)
        }

        item {
            ScreenTitle(
                title = "BeautyNote",
                subtitle = "\"Discover your beauty collection.\""
            )
        }

        item {
            AppLogo()
        }

        item {
            ProductSearchBar(
                iconResource = R.drawable.ic_search,
                labelText = "Search by brand",
                onSearch = { query -> searchQuery = query }
            )
        }

        item {
            MakeupCategories(selectedType = selectedType) { newType ->
                selectedType = newType
            }
        }

        val filteredProducts = productsList.filter {
            it.type == selectedType && it.brand.contains(searchQuery, ignoreCase = true)
        }

        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                items(filteredProducts.size) { index ->
                    ProductCard(
                        imageResource = filteredProducts[index].image,
                        title = filteredProducts[index].name,
                        subtitle = filteredProducts[index].brand,
                        productId = filteredProducts[index].id,
                        navigation = navigation
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }

        item {
            IconButton(
                iconResource = R.drawable.ic_plus,
                text = "Add new product",
                onClick = {
                    navigation.navigate(Routes.SCREEN_ADD_PRODUCT)
                }
            )
        }
    }
}

@Composable
fun ScreenTitle(title: String, subtitle: String) {
    Box(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = title,
                style = TextStyle(
                    color = Color(0xffc2185b),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp,
                    textDecoration = TextDecoration.Underline,
                ),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = subtitle,
                style = TextStyle(
                    color = Color(0xff616161),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    fontStyle = FontStyle.Italic,
                    letterSpacing = 1.5.sp
                ),
                modifier = Modifier
                    .padding(vertical = 6.dp)
                    .align(Alignment.CenterHorizontally)

            )
        }
    }
}

@Composable
fun ProductSearchBar(
    @DrawableRes iconResource: Int,
    labelText: String,
    onSearch: (String) -> Unit,

    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        containerColor = Color.Transparent,

        unfocusedTextColor = Color(0xffc2185b),
        focusedTextColor = Color(0xff616161),

        unfocusedLabelColor = Color(0xffc2185b),
        focusedLabelColor = Color(0xffc2185b),

        focusedIndicatorColor = Color(0xffc2185b),
        unfocusedIndicatorColor = Color.Transparent,
    )
) {
    var searchInput by remember { mutableStateOf("") }

    TextField(
        value = searchInput,
        onValueChange = {
            searchInput = it
            onSearch(it)
        },
        label = { Text(labelText) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = labelText,
                tint = Color(0xff616161),
                modifier = Modifier
                    .width(17.dp)
                    .height(17.dp)
            )
        },
        colors = colors,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 30.dp, bottom = 18.dp)
            .background(Color(0xFFFCE4EC), shape = RoundedCornerShape(8.dp))

    )
}

@Composable
fun TabButton(
    text: String,
    isActive: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(24.dp),
        elevation = null,
        colors = if (isActive) {
            ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color(0xffc2185b)
            )
        } else {
            ButtonDefaults.buttonColors(
                contentColor = Color(0xffc2185b),
                containerColor = Color.White
            )
        },
        modifier = Modifier.fillMaxHeight(),
    ) {
        Text(text)
    }
}

@Composable
fun MakeupCategories(selectedType: String, onTypeSelected: (String) -> Unit) {

    val categories = listOf("Face", "Eyes", "Lips", "Brows")

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 2.dp)
            .background(Color.Transparent)
            .fillMaxWidth()
            .height(44.dp)


    ) {
        categories.forEachIndexed { index, category ->
            TabButton(
                text = category,
                isActive = selectedType == category,
                onClick = { onTypeSelected(category) }
            )
            if (index < categories.size - 1) {
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
    }
}

@Composable
fun ChoiceButton(navController: NavController, currentActiveButton: Int, onButtonClick: (Int) -> Unit) {

    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(top = 70.dp, bottom = 10.dp)
            .background(Color.Transparent)
            .fillMaxWidth()
            .height(44.dp)
    ) {
        TabButton(
            text = "Products",
            isActive = currentActiveButton == 0
        ) {
            onButtonClick(0)
            navController.navigate(Routes.SCREEN_ALL_PRODUCTS)
        }

        Spacer(modifier = Modifier.width(15.dp))

        TabButton(
            text = "List",
            isActive = currentActiveButton == 1
        ) {
            onButtonClick(1)
            navController.navigate(Routes.SCREEN_LIST)
        }
    }
    Spacer(modifier = Modifier.width(4.dp))
}

@Composable
fun AppLogo() {

    Image(
        painter = painterResource(id = R.drawable.product),
        contentDescription = "Logo",
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun ProductCard(
    imageResource: String,
    title: String,
    subtitle: String,
    productId: String,
    navigation: NavController,
) {

    val validImageUrl = if (imageResource.startsWith("http")) imageResource else "default_image_url"

    Box(
        modifier = Modifier
            .width(270.dp)
            .height(290.dp)
            .padding(top=20.dp, bottom = 18.dp)
    ) {
        val painter = rememberAsyncImagePainter(
            model = imageResource,
            error = painterResource(id = R.drawable.error_photo),
            placeholder = painterResource(id = R.drawable.placeholder)
        )

        Image(
            painter = painter,
            contentDescription = "Product Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(title, color = Color(0xffad1457))
            Text(subtitle, color = Color(0xffff80ab))
            // Corrected navigation logic
            Button(
                onClick = {

                            navigation.navigate(Routes.getProductDetailsPath(productId))
                            val route = Routes.getProductDetailsPath(productId)
                            navigation.navigate(route)
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color(0xfff8bbd0),
                    containerColor = Color(0xffc2185b)
                )
            ) {
                Text(text = "See details")
            }

        }
    }
}















