package collections

interface MyMutableList<T> {

    val size: Int

    operator fun plus(element: T)

    operator fun minus(element: T)

    fun add(element: T)

    fun add(index: Int, element: T)

    operator fun get(index: Int): T

    fun removeAt(index: Int)

    fun remove(element: T)

    fun clear()

    fun contains(element: T): Boolean
}