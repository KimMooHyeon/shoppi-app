package screen

class ShoppingHome {

    fun start() {
        showWelcomeMessage()
        showCategories()
    }

    private fun showWelcomeMessage() {
        println(
            """
            Hello, Welcome to the Shoppi!
            If you want to shopping then plz tell me your name :)"
        """.trimIndent()
        )
        val userName = readLine()
        println(
            """
            Thank you, $userName
            Choice your category!
            ***=======================***
        """.trimIndent()
        )
    }

    private fun showCategories() {
        val shoppingCategory = ShoppingCategory()
        shoppingCategory.showCategories()
    }
}