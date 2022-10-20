package screen

import LINE_DIVIDER
import data.CartItems
import extensions.getNotEmptyString

class ShoppingCart : Screen() {
    private val products = CartItems.products
    fun showCartItem() {
        ScreenStack.push(this)
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
        } else {
            println(
                """
                Empty Cart
            """.trimIndent()
            )
        }
        showPreviousScreenOption()
    }

    private fun showPreviousScreenOption() {
        println(
            """
            
            $LINE_DIVIDER
            Want to Go Previous Screen? (y/n)
        """.trimIndent()
        )
        when (readln().getNotEmptyString()) {
            "y" -> {
                moveToPreviousScreen()
            }
            "n" -> {
                showCartItem()
            }
            else -> {
                // 재입력
            }
        }
    }

    private fun moveToPreviousScreen() {
        ScreenStack.pop()
        when (val previousScreen : Screen? = ScreenStack.peek()) {
            is ShoppingCategory -> {
                previousScreen.showCategories()
            }
            is ShoppingProductList -> {
                previousScreen.showProducts()
            }
            is ShoppingCart, is ShoppingHome -> {

            }
            else -> {
                //프로그램 종료
            }
        }
    }
}

