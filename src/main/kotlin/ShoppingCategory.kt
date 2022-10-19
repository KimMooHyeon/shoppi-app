class ShoppingCategory {
    fun showCategories() {
        val categories = arrayOf("Fashion", "Electronics", "Fat Products")
        for (category in categories) {
            println(category)
        }

        println("=> If you want to go Cart then write #")

        var selectedCategory = readLine()
        while (selectedCategory.isNullOrBlank()) {
            println("값을 입력해주세요.")
            selectedCategory = readLine()
        }
        if (selectedCategory == "#") {

        } else {
            if (categories.contains(selectedCategory)) {
                // 상품 목록 표출
            } else {
                showErrorMessage(selectedCategory)
            }
        }
    }

    private fun showErrorMessage(selectedCategory: String?) {
        println("[${selectedCategory}] : Not Exist Category, plz Again")
    }
}