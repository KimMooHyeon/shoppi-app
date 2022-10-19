package screen

import extensions.getNotEmptyString

class ShoppingCategory {
    fun showCategories() {
        val categories = arrayOf("Fashion", "Electronics", "Fat Products")
        for (category in categories) {
            println(category)
        }

        println("=> If you want to go Cart then write #")

        val selectedCategory = readLine().getNotEmptyString()

        if (selectedCategory == "#") {
            //장바구니 이동
            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItem()
        } else {
            if (categories.contains(selectedCategory)) {
                val shoppingProductList = ShoppingProductList()
                shoppingProductList.showProducts(selectedCategory)
            } else {
                showErrorMessage(selectedCategory)
            }
        }
    }

    private fun showErrorMessage(selectedCategory: String?) {
        println("[${selectedCategory}] : Not Exist Category, plz Again")
    }

}