package com.example.beautynoteapp.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.beautynoteapp.R
import com.example.beautynoteapp.Routes
import com.example.beautynoteapp.data.FullProductViewModel
import com.example.beautynoteapp.data.Product


@Composable
fun TopImageAndBar(
    navigation: NavController,
    product: Product
) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxHeight()
        ) {
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .height(56.dp)
                    .padding(horizontal = 16.dp)
            ) {
                CircularButton(
                    iconResource = R.drawable.ic_arrow_back,
                    color = Color(0xffc51162),
                    onClick = {
                        navigation.navigate(Routes.SCREEN_ALL_PRODUCTS)
                    }
                )

                StatusButton(product = product)
            }
        }
    }
}

@Composable
fun CircularButton(
    @DrawableRes iconResource: Int,
    color: Color = White,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(defaultElevation = 12.dp),
    onClick: () -> Unit = {}
) {
    Button(
        contentPadding = PaddingValues(),
        elevation = elevation,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = color, contentColor = White),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .width(35.dp)
            .height(35.dp)
    ) {
        Icon(
            painter = painterResource(id = iconResource),
            contentDescription = null
        )
    }
}


@Composable
fun StatusButton(
    product: Product
) {

    var statusIndex by remember { mutableStateOf(product.status) }

    val icons = listOf(R.drawable.full, R.drawable.half, R.drawable.empty)
    val colors = listOf(Color(0xffc51162), Color(0xffc51162), Color(0xffc51162))


    Button(
        contentPadding = PaddingValues(),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp),
        onClick = {
            statusIndex = (statusIndex + 1) % icons.size
            product.status = statusIndex
        },
        colors = ButtonDefaults.buttonColors(containerColor = colors[statusIndex], contentColor = Color.White),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .width(35.dp)
            .height(35.dp)
    ) {
        Icon(
            painter = painterResource(id = icons[statusIndex]),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun ScreenInfo(
    name: String,
    brand: String,
    imageResource: Any,
) {

    Column {

        val painter = rememberAsyncImagePainter(
            model = imageResource,
            error = painterResource(id = R.drawable.error_photo),
            placeholder = painterResource(id = R.drawable.placeholder)

        )
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(start = 106.dp)
                .border(3.dp, Color(0xffc51162), RectangleShape)
                .size(200.dp)

        )
        Text(
            text = brand,
            style = TextStyle(color = Color(0xfff06292), fontSize = 24.sp, fontWeight = FontWeight.Medium),
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
        Text(
            text = name,
            style = TextStyle(color = Color.Black, fontSize = 20.sp,
                fontWeight = FontWeight.Bold),
                modifier = Modifier
                .padding(horizontal = 16.dp)
        )

    }
}

@Composable
fun InfoColumn(
    @DrawableRes iconResource: Int,
    text: String,
    type: String,
    price: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = iconResource),
            contentDescription = null,
            tint = Pink,
            modifier = Modifier.height(24.dp)
        )

        Text(text = text, fontWeight = FontWeight.Bold)
        Column(
            horizontalAlignment = Alignment.Start){
            Text(text = "Type: $type", fontWeight = FontWeight.Medium)
            Text(text = "Price: $price", fontWeight = FontWeight.Medium)
        }

    }
}

@Composable
fun BasicInfo(product: Product) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        InfoColumn(R.drawable.ic_star, product.rating, product.type, product.price)
    }
}

@Composable
fun Description(product: Product, onDelete: () -> Unit) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        product.description.forEach { desc ->
            if (desc.fullName.isNotEmpty()) {
                Text(
                    text = "${desc.fullName}",
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(color = Color(0xffc51162), fontSize = 20.sp),
                    modifier = Modifier.padding(vertical = 4.dp)
                        .padding(bottom = 20.dp)
                )
            }


            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {
                if (desc.shade.isNotEmpty()) {
                    Text(
                        text = "Shade: ",
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(textDecoration = TextDecoration.Underline, fontSize = 18.sp),
                        color = Color(0xfff06292),
                    )
                    Text(
                        text = desc.shade,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                        style = TextStyle(fontSize = 18.sp),
                        modifier = Modifier.padding(start = 26.dp)
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.padding(bottom = 5.dp)
            ) {

                if (desc.packaging.isNotEmpty()) {
                    Text(
                        text = "Package: ",
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(textDecoration = TextDecoration.Underline, fontSize = 18.sp),
                        color = Color(0xfff06292),
                    )
                    Text(
                        text = desc.packaging,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                        style = TextStyle(fontSize = 18.sp),
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }}

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                if (desc.purpose.isNotEmpty()) {
                    Text(
                        text = "Purpose: ",
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(textDecoration = TextDecoration.Underline, fontSize = 18.sp),
                        color = Color(0xfff06292),
                        modifier = Modifier.padding(top = 2.dp, bottom = 5.dp)
                    )
                    Text(
                        text = desc.purpose,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                        style = TextStyle(fontSize = 18.sp),
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }}
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.padding(top = 5.dp)

            ) {
                if (desc.collection.isNotEmpty()) {
                    Text(
                        text = "Collection: ",
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(textDecoration = TextDecoration.Underline, fontSize = 18.sp),
                        color = Color(0xfff06292),
                        modifier = Modifier.padding(bottom=20.dp)
                    )
                    Text(
                        text = desc.collection,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                        style = TextStyle(fontSize = 18.sp),
                        modifier = Modifier.padding(start = 7.dp, bottom=20.dp)
                    )
                }}

            Spacer(modifier = Modifier.width(4.dp))

            CircularButton(
                iconResource = R.drawable.x__1_,
                color = Color(0xffc51162),
                onClick = { onDelete() }
            )
        }
    }
}



@Composable
fun ProductDetailsScreen(
    navigation: NavController,
    productId: Int,
    viewModel: FullProductViewModel
) {
    val product = viewModel.getProductById(productId)

    if (product == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Product not found", color = Color.Red)
        }
        return
    }

    val onDelete: () -> Unit = {
        viewModel.removeProduct(productId)
        navigation.popBackStack()
    }

    val scrollState = rememberLazyListState()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.backgrounddetail),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        LazyColumn(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            state = scrollState,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
        ) {
            item {
                TopImageAndBar(
                    navigation = navigation,
                    product = product
                )

                ScreenInfo(name = product.name, brand = product.brand, imageResource = product.image)

                BasicInfo(product)

                Description(
                    product = product, onDelete = onDelete
                )
            }
        }
    }
}




@Composable
fun IconButton(
    @DrawableRes iconResource: Int,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xfff8bbd0),
            contentColor = Color(0xffc2185b)
        ),
        shape = RoundedCornerShape(80),
        modifier = Modifier
            .height(60.dp)
            .padding(bottom = 10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = text,
                tint = Color(0xffc2185b),
                modifier = Modifier.size(18.dp)
            )

            Spacer(Modifier.width(8.dp))

            Text(
                text = text,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xffc2185b)
                )
            )
        }
    }
}





