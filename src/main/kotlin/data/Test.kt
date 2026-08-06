package data

fun main() {
//    val (first, second) = MyPair("", "")
    val dictionary = listOf(
        "hello".myTo("bonjour"),
        "thank you" myTo "merci"
    )
    for ((first, second) in dictionary) {
        println("$first - $second")
    }
}

data class MyPair<F, S>(val first: F, val second: S)

infix fun <F, S> F.myTo(second: S) = MyPair(this, second)