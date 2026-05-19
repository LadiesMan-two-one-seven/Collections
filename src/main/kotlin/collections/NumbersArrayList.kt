package collections

class NumbersArrayList(initialCapacity: Int = INITIAL_CAPACITY) : NumbersMutableList {

    private var numbers = arrayOfNulls<Int>(initialCapacity)

    override var size: Int = 0
        private set

    override fun plus(number: Int) {
        add(number)
    }

    override fun minus(number: Int) {
        remove(number)
    }

    fun growIfNeeded() {
        if (numbers.size == size) {
            val newArray = arrayOfNulls<Int>(numbers.size * 2)
            for (index in numbers.indices) {
                newArray[index] = numbers[index]
            }
            numbers = newArray
        }
    }

    // O(1)
    override fun add(number: Int) {
        growIfNeeded()
        numbers[size] = number
        size++
    }

    // O(n)
    override fun add(index: Int, number: Int) {
        growIfNeeded()
        for (i in size downTo index + 1) {
            numbers[i] = numbers[i - 1]
        }
        numbers[index] = number
        size++
    }

    // O(1)
    override fun get(index: Int): Int {
        return numbers[index]!!
    }

    // O(n)
    override fun removeAt(index: Int) {
        for (i in index until size - 1) {
            numbers[i] = numbers[i + 1]
        }
        size--
        numbers[size] = null
    }

    // O(n)
    override fun remove(number: Int) {
        for (i in numbers.indices) {
            if (numbers[i] == number) {
                removeAt(i)
                return
            }
        }
    }

    // O(1)
    override fun clear() {
        numbers = arrayOfNulls(INITIAL_CAPACITY)
        size = 0
    }

    // O(n)
    override fun contains(number: Int): Boolean {
        for (i in numbers.indices) {
            if (numbers[i] == number) {
                return true
            }
        }
        return false
    }

    companion object {

        private const val INITIAL_CAPACITY = 10
    }
}