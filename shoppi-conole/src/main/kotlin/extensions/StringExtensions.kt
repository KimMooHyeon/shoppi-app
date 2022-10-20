package extensions

fun String?.getNotEmptyString(): String {
    var input = this
    while (input.isNullOrBlank()) {
        println("input is Null or Blank, plz Press Again")
        input = readLine()
    }
    return input.trim()
}

fun String?.getNotEmptyInt(): Int {
    var input = this?.trim()
    while (input.isNullOrEmpty() || input.toIntOrNull()==null){
        println("input is Null or Blank or Not Number, plz Press Again")
        input = readLine()
    }
    return input.toInt()
}