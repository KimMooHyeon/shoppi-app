package screen

import data.CartItems

class ShoppingCart {
    private val products = CartItems.products
    fun showCartItem() {
        if (products.isNotEmpty()) {
            println(products.keys.joinToString(
                ". \n",
                """
                    ***=======================***
                    It is your cart Item
                    
                    """.trimIndent()
            ) { product ->
                "category : ${product.categoryLabel} / name : ${product.name} / amount : ${products[product]}"
            }
            )
        }else{
            println("""
                Empty Cart
            """.trimIndent())
        }
    }
}

