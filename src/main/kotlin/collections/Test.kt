package collections

fun main() {
    val numbers = hashSetOf<Int>()
    repeat(100) {
        numbers.add(it)
    }
    for (number in numbers) {
        println(number)
    }
}