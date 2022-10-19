fun main(args: Array<String>) {

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
    if (selectedCategory == "#"){

    }else{

    }

}

/*
 1. 상품 카테고리 표기
 2. 사용자 입력
 3. 사용자가 기대하는 값 입력
 */