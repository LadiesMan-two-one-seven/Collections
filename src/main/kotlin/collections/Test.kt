package collections

import kotlin.random.Random

fun main() {
    val numbers = MyHashSet<Int>()
    repeat(100) {
        numbers.add(Random.nextInt(1000))
    }
    numbers.elements.forEach(::println)
}