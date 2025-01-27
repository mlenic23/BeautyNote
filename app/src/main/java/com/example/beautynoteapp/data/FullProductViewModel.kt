package com.example.beautynoteapp.data

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class FullProductViewModel : ViewModel() {
    val productsData = mutableStateListOf<Product>()
    val products: List<Product> get() = productsData

    init{
        productsData.addAll(
            listOf(
                Product(
                    id = 0,
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
                    id = 1,
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
                    id = 2,
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
                    id = 3,
                    image = "https://www.beautyaz.gr/19272-large_default/essence-make-me-brow-eyebrow-gel-mascara-04-ashy-brows-38ml.jpg",
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
        )

    }

    fun addProduct(product:Product){
        val newId = (productsData.maxOfOrNull { it.id } ?: 0) + 1
        productsData.add(product.copy(id = newId))
    }

    fun getProductById(id: Int): Product? {
        return productsData.find { id == id }
    }

}

