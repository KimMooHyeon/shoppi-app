package screen

import LINE_DIVIDER
import data.CartItems

class ShoppingCart {
    private val products = CartItems.products
    fun showCartItem() {
        if (products.isNotEmpty()) {
            println(products.keys.joinToString(
                ". \n",
                """
                    $LINE_DIVIDER
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

