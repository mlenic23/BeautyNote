package com.example.beautynoteapp.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.beautynoteapp.R


/*@Composable
fun ProductList(
    products: List<Product>,
    navigation: NavController
) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(
                text = "7 recipes",
                style = TextStyle(color = Color.DarkGray, fontSize =
                14.sp)
            )
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            items(products.size) { index ->

                ProductCard(
                    imageResource = products[index].image,
                    title = products[index].name,
                    subtitle = products[index].brand,
                    productId = index,
                    navigation = navigation
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}*/


@Composable
fun TopImageAndBar(
    @DrawableRes coverImage: Int,
    navigation: NavController,
    product: Product
) {
    var isUsed by remember { mutableStateOf(product.isUsed) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxHeight()
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
                    R.drawable.ic_arrow_back, color =  Color(0xffc51162),  onClick = { navigation.navigate(Routes.SCREEN_ALL_PRODUCTS) })
                StatusButton(
                    iconResource = if (isUsed) R.drawable.tick else R.drawable.x__1_,
                    color = if (isUsed) Color(0xffc51162) else Color.LightGray,
                    text = if (isUsed) "New" else "Empty",
                    onClick = {
                        isUsed = !isUsed
                        product.isUsed = isUsed
                    }
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.White
                            ),
                            startY = 100f
                        )
                    )
            )
        }
    }
}

@Composable
fun CircularButton(
    @DrawableRes iconResource: Int,
    color: Color=White,
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
            contentDescription = null,
        )
    }
}

@Composable
fun StatusButton(
    @DrawableRes iconResource: Int,
    color: Color=White,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(defaultElevation = 12.dp),
    onClick: () -> Unit = {},
    text : String
) {
    Column(){
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
                contentDescription = null,
                modifier = Modifier.size(17.dp)
            )

        }
        Text(
            text = text,
            color = Color.Black,)
    }

}




@Composable
fun ScreenInfo(
    name: String,
    brand: String,
    @DrawableRes imageResource: Int,
) {

    Column {

        Image(
            painter = painterResource(imageResource),
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
fun Description(product: Product) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        product.description.forEach { desc ->
            if (desc.fullName.isNotEmpty()) {
                Text(
                    text = "${desc.fullName}",
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(color = Color(0xffc51162), fontSize = 20.sp),
                    modifier = Modifier.padding(vertical = 4.dp)
                        .padding(bottom=20.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.padding(bottom = 5.dp)
            ) {
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
            }}

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
                verticalArrangement = Arrangement.Center, // Centriranje u vertikalnom smjeru
                horizontalAlignment = Alignment.Start, // Poravnanje lijevo
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
                )
                Text(
                    text = desc.collection,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    style = TextStyle(fontSize = 18.sp),
                    modifier = Modifier.padding(start = 7.dp)
                )
            }}
        }
    }
}



@Composable
fun ListButton() {
    Button(
        onClick = { /*TODO*/ },
        elevation = null,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xffc51162),
            contentColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 70.dp)
            .padding(top = 20.dp)


    ) {
        Text(text = "Add to list", modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun ProductDetailsScreen(
    navigation: NavController,
    productId: Int,

) {
    val product = products.getOrNull(productId) ?: return


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Pozadina (slika)
        Image(
            painter = painterResource(id = R.drawable.backgrounddetail),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        LazyColumn(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp) // Ovdje možete dodati padding da ne bude previše uz rubove
        ) {
            item {
                TopImageAndBar(
                    coverImage = product.image,
                    navigation = navigation,
                    product = product
                )
                ScreenInfo(product.name, product.brand, product.image)
                BasicInfo(product)
                Description(product)
                ListButton()

            }
        }
    }
}


@Composable
fun IconButton(
    @DrawableRes iconResource: Int,
    text: String
) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = White,
            contentColor = Color(0xffc2185b)
        ),
        shape = RoundedCornerShape(80),
        modifier = Modifier
            .height(60.dp)


    ) {
        Row {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = text,
                tint = Color(0xffc2185b),
                modifier = Modifier.size(18.dp)
            )

            Spacer(Modifier.width(2.dp))

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



