package screen

import LINE_DIVIDER
import extensions.getNotEmptyString

class ShoppingHome : Screen() {

    fun start() {
        showWelcomeMessage()
        showCategories()
    }

    private fun showWelcomeMessage() {
        ScreenStack.push(this)
        println(
            """
            Hello, Welcome to the Shoppi!
            If you want to shopping then plz tell me your name :)"
        """.trimIndent()
        )
        val userName = readLine().getNotEmptyString()
        println(
            """
            Thank you, $userName
            Choice your category!
            $LINE_DIVIDER
        """.trimIndent()
        )
    }

    private fun showCategories() {
        val shoppingCategory = ShoppingCategory()
        shoppingCategory.showCategories()
    }
}