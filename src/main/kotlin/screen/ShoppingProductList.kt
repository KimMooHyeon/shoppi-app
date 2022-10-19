package screen

import LINE_DIVIDER
import data.CartItems
import data.Product
import extensions.getNotEmptyInt
import extensions.getNotEmptyString

class ShoppingProductList {
    private val products = arrayOf(
        Product("Fashion", "Winter Clothes"),
        Product("Fashion", "Winter Pants"),
        Product("Electronics", "Winter SmartPhone"),
        Product("Electronics", "AirPods"),
        Product("Electronics", "MacBooks"),
        Product("Fat Products", "Dry food"),
        Product("Fat Products", "Wet food"),
        Product("Fat Products", "Toothpaste"),
        Product("Fat Products", "Snack")
    )
    private val categories: Map<String, List<Product>> = products.groupBy { product ->
        product.categoryLabel
    }

    fun showProducts(selectedCategory: String) {
        val categoryProducts = categories[selectedCategory]
        if (!categoryProducts.isNullOrEmpty()) {
            println(
                """
                $LINE_DIVIDER
                It is [${selectedCategory}] Products.
                
            """.trimIndent()
            )
            categoryProducts.forEachIndexed { index, product ->
                println("$index $product")
            }
            showCartOption(categoryProducts,selectedCategory)
        } else {
            showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showEmptyProductMessage(selectedCategory: String) {
        println("[${selectedCategory}] is Empty List")
    }

    private fun showCartOption(categoryProduct: List<Product>,selectedCategory:String){
        println("""
            $LINE_DIVIDER
            Choice Number Your Product Number
        """.trimIndent())
        val selectedIndex = readLine().getNotEmptyInt()
        categoryProduct.getOrNull(selectedIndex)?.let { product ->
            CartItems.addProduct(product)
            println("=> Want to Go Cart then Press # , or Continue Press *")
            val answer = readLine().getNotEmptyString()
            if (answer == "#"){
                val shoppingCart = ShoppingCart()
                shoppingCart.showCartItem()
            }else if(answer =="*"){
                showProducts(selectedCategory)
            }
        }
    }
}