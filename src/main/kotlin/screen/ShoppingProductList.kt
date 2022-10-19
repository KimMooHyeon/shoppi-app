package screen

import data.Product

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
                ***=======================***
                It is [${selectedCategory}] Products.
                
            """.trimIndent()
            )
            categoryProducts.forEachIndexed { index, product ->
                println("${index + 1} $product")
            }
        } else {
            showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showEmptyProductMessage(selectedCategory: String) {
        println("[${selectedCategory}] is Empty List")
    }
}