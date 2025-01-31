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
                    id = 1,
                    image = "https://www.lijepa.hr/data/cache/thumb_min500_max1000-min500_max1000-12/products/339187/1683200741/vichy-liftactiv-flexiteint-spf20-puder-za-zene-30-ml-odstin-15-opal-283254.jpg",
                    name = "Powder",
                    brand = "Vichy",
                    description = listOf(
                        Description(
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
                    status = 0
                ),

                Product(
                    id = 2,
                    image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2IM1KHa8f7G5HWwX1Iozr-gX4sixf2aFXCA&s",
                    name = "Mascara",
                    brand = "Maybelline",
                    description = listOf(
                        Description(
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
                    status = 0

                    ),

                Product(
                    id = 3,
                    image = "https://www.bnedutyfree.com.au/media/catalog/product/cache/e6410293f9a24f502cd707ec5c46309d/7/d/7dee3a48-e070-4d61-b583-c76a958b22d5.jpeg",
                    name = "Lipstick",
                    brand = "MAC",
                    description = listOf(
                        Description(
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
                    status = 0

                    ),

                Product(
                    id = 4,
                    image = "https://www.beautyaz.gr/19272-large_default/essence-make-me-brow-eyebrow-gel-mascara-04-ashy-brows-38ml.jpg",
                    name = "Brow gel",
                    brand = "Essence",
                    description = listOf(
                        Description(
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
                    status = 0

                    ),

                Product(
                    id = 5,
                    image = "https://www.narscosmetics.com/on/demandware.static/-/Sites-itemmaster_NARS/default/dw863c82e8/2023/December/AfterglowEyeshadow/0194251143316_1.png",
                    name = "Eyeshadow palette",
                    brand = "Nars",
                    description = listOf(
                        Description(
                            fullName = "Afterglow irresistible eyeshadow palette",
                            shade = "Adoration, Amorous, Blaze...",
                            packaging = "12 shadows",
                            purpose = "Palette create endless eye looks with romantic rose, peach, and neutral shadows curated in a delightfully pink, limited-edition palette for sultry smolder.",
                            collection = "Afterglow"
                        )

                    ),
                    type = "Eyes",
                    price = "60€",
                    rating = "5",
                    status = 0

                    ),

                Product(
                    id = 6,
                    image = "https://www.lijepa.hr/data/cache/thumb_min500_max1000-min500_max1000-12/products/450060/1686280312/mac-extra-dimension-blush-rumenilo-za-zene-4-g-nijansa-sweets-for-my-sweet-484418.jpg",
                    name = "Blush",
                    brand = "MAC",
                    description = listOf(
                        Description(
                            fullName = "MAC extra dimension blush",
                            shade = "Sweets For My Sweet",
                            packaging = "4g",
                            purpose = "A creamy powder blush that delivers a silky finish and long-lasting color.",
                            collection = "Extra Dimension"
                        )

                    ),
                    type = "Face",
                    price = "34€",
                    rating = "4",
                    status = 0

                    ),

                Product(
                    id = 7,
                    image = "https://static.beautytocare.com/cdn-cgi/image/width=1600,height=1600,f=auto/media/catalog/product//e/s/essence-gimme-glow-luminous-highlighter-20-lovely-rose-9g_1.jpg",
                    name = "Highlighter",
                    brand = "Essence",
                    description = listOf(
                        Description(
                            fullName = "Gimme Glow Luminous Highlighter",
                            shade = "Golden Goddess",
                            packaging = "10g",
                            purpose = "This highlighter is designed to provide a radiant, luminous glow to the skin, perfect for adding a stunning highlight to the cheekbones, brow bones, and other high points of the face.",
                            collection = "Luminous Highlighter"
                        )

                    ),
                    type = "Face",
                    price = "9€",
                    rating = "3",
                    status = 0

                    ),

                Product(
                    id = 8,
                    image = "https://www.lijepa.hr/data/cache/thumb_min500_max1000-min500_max1000-12/products/460993/1720754217/maybelline-color-sensational-shaping-lip-liner-olovka-za-usne-za-zene-1-2-g-nijansa-20-nude-569770.jpg",
                    name = "Lip liner",
                    brand = "Maybelline",
                    description = listOf(
                        Description(
                            fullName = "Maybelline color sensational shaping lip liner",
                            shade = "20 Nude Seduction",
                            packaging = "1.2g",
                            purpose = "Maybelline Lip Liner defines and enhances your lips with smooth, long-lasting color for a flawless finish.",
                            collection = "Color Sensational collection"
                        )

                    ),
                    type = "Lips",
                    price = "6€",
                    rating = "4",
                    status = 0

                    ),

                Product(
                    id = 9,
                    image = "https://www.revolutionbeauty.com/dw/image/v2/BCZJ_PRD/on/demandware.static/-/Sites-revbe-master-catalog/default/dwbd6e9727/images/hi-res/MURULBRMD_3.jpg?sw=660&sh=660&sm=fit&strip=false",
                    name = "Eyebrow Palette Kit",
                    brand = "Revolution",
                    description = listOf(
                        Description(
                            fullName = "The ultimate brow enhancing kit",
                            shade = "Medium to Dark",
                            packaging = "9",
                            purpose = "The Revolution Eyebrow Palette Kit is designed to shape, define, and fill in your eyebrows, offering multiple shades to suit different hair colors for a flawless, natural finish.",
                            collection = "Revolution Pro"
                        )

                    ),
                    type = "Brows",
                    price = "10€",
                    rating = "5",
                    status = 0

                    ),


                Product(
                    id = 10,
                    image = "https://licilasicdn.s3.amazonaws.com/public/product_images/41700/gallery/original/533183897.jpg",
                    name = "Contour",
                    brand = "NYX",
                    description = listOf(
                        Description(
                            fullName = "NYX Professional Makeup wonder stick",
                            shade = "Fair",
                            packaging = "8g",
                            purpose = "Wonder Stick is a dual-ended stick with a creamy texture, allowing for easy and precise face sculpting",
                            collection = "NYX Professional"
                        )

                    ),
                    type = "Face",
                    price = "11€",
                    rating = "3",
                    status = 0

                    ),

                Product(
                    id = 11,
                    image = "https://designeroptics.com/cdn/shop/files/b05ff878f2414c96cd4e2e4539e87b8b.jpg?v=1693250817",
                    name = "Concealer",
                    brand = "Nars",
                    description = listOf(
                        Description(
                            fullName = "Nars mini radiant creamy concealer",
                            shade = "Nougatine",
                            packaging = "1.4ml",
                            purpose = "Concealer offer buildable, long-lasting coverage",
                            collection = "Radiant Creamy"
                        )

                    ),
                    type = "Face",
                    price = "15€",
                    rating = "5",
                    status = 0

                    ),

                Product(
                    id = 12,
                    image = "https://licilasicdn.s3.amazonaws.com/public/product_images/47117/main/original.jpg",
                    name = "Eyeliner",
                    brand = "Catrice",
                    description = listOf(
                        Description(
                            fullName = "Catrice Calligraph Pro Precise 24h Matt",
                            shade = "010 Intense Black Waterproof",
                            packaging = "1.2ml",
                            purpose = "This eyeliner is designed to create precise lines with a long-lasting matte finish. Its formula provides high pigmentation and is resistant to water, sweat, and smudging, making it ideal for all-day wear.",
                            collection = "Calligraph Pro collection"
                        )

                    ),
                    type = "Eyes",
                    price = "4€",
                    rating = "2",
                    status = 0

                    ),

                Product(
                    id = 13,
                    image = "https://cdn.notinoimg.com/social/maybelline/03600531609689_01-o/maybelline-new-york-lifter-gloss-sjajilo-za-usne___201201.jpg",
                    name = "Lip gloss",
                    brand = "Maybelline",
                    description = listOf(
                        Description(
                            fullName = "Maybelline NEW YORK lifter gloss",
                            shade = "02 Ice",
                            packaging = "5.4ml",
                            purpose = "Maybelline New York Lifter Gloss enhances your lips with a high-shine finish and hydrating formula for a fuller, smoother look.",
                            collection = "Lifter Gloss"
                        )

                    ),
                    type = "Lips",
                    price = "8€",
                    rating = "5",
                    status = 0

                    ),

                Product(
                    id = 14,
                    image = "https://m.media-amazon.com/images/I/21F2c4FkUBL._BO30,255,255,255_UF900,850_SR1910,1000,0,C_QL100_.jpg",
                    name = "Eyebrow pencil",
                    brand = "Alverde",
                    description = listOf(
                        Description(
                            fullName = "Automatic eyebrow pencil",
                            shade = "06 Espresso",
                            packaging = "0.45g",
                            purpose = "Eyebrow pencil delivers precise, long-lasting definition for perfectly shaped brows with ease.",
                            collection = "Alverde")

                    ),
                    type = "Brows",
                    price = "3€",
                    rating = "1",
                    status = 0

                    ),

                ))
    }

    fun addProduct(product:Product){
        val newId = (productsData.maxOfOrNull { it.id } ?: 0) + 1
        productsData.add(product.copy(id = newId))
    }

    fun getProductById(productId: Int): Product? {
        return productsData.find { it.id == productId }
    }

    fun removeProduct(productId: Int) {
        productsData.removeIf { it.id == productId }
    }

}

