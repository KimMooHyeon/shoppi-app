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
        val categories = arrayOf("패션", "전자기기", "반려동물용품")
        for (category in categories) {
            println(category)
        }

        println("=> 장바구니로 이동하시려면 #을 입력해주세요")

        var selectedCategory = readLine()
        while (selectedCategory.isNullOrBlank()) {
            println("값을 입력해주세요.")
            selectedCategory = readLine()
        }
        if (selectedCategory == "#") {

        } else {

        }
    }

}