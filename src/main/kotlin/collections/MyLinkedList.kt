package collections

class MyLinkedList<T> : MyMutableList<T> {

    private var first: Node<T>? = null
    private var last: Node<T>? = null
    private var modCount = 0

    override var size: Int = 0
        private set

    override fun plus(element: T) {
        add(element)
    }

    override fun minus(element: T) {
        remove(element)
    }

    // O(1)
    override fun add(element: T): Boolean {
        modCount++
        val prevLast = last
        last = Node(prevLast, element)
        if (prevLast == null) {
            first = last
        } else {
            prevLast.next = last
        }
        size++
        return true
    }

    // O(1) if index is 0 or (size) else O(n)
    override fun add(index: Int, element: T) {
        modCount++
        checkIndexForAdding(index)
        if (index == size) {
            add(element)
            return
        }
        if (index == 0) {
            val node = Node(null, element, first)
            first?.prev = node
            first = node
            size++
            return
        }
        val before = getNode(index - 1)
        val after = before.next
        val newNode = Node(before, element, after)
        before.next = newNode
        after?.prev = newNode
        size++
    }

    // O(n)
    override fun get(index: Int): T {
        checkIndex(index)
        return getNode(index).item
    }

    // O(n) and not O(n/2)
    private fun getNode(index: Int): Node<T> {
        if (index == 0) return first!!
        if (index == size - 1) return last!!

        if (index < size / 2) {
            var node = first
            repeat(index) {
                node = node?.next
            }
            return node!!
        } else {
            var node = last
            repeat(size - index - 1) {
                node = node?.prev
            }
            return node!!
        }
    }

    // O(1) if index is 0 or (size) else O(n)
    override fun removeAt(index: Int) {
        // modCount++
        checkIndex(index)
        val node = getNode(index)
        unlink(node)
    }

    private fun unlink(node: Node<T>) {
        modCount++
        val before = node.prev
        val after = node.next
        before?.next = after
        after?.prev = before
        if (after == null) {
            last = before
        }
        if (before == null) {
            first = after
        }
        size--
    }

    // O(n)
    override fun remove(element: T) {
        // modCount++
        var node = first
        repeat(size) {
            if (node?.item == element) {
                unlink(node)
                return
            } else {
                node = node?.next
            }
        }
    }

    override fun clear() {
        modCount++
        first = null
        last = null
        size = 0
    }

    // O(n)
    override fun contains(element: T): Boolean {
        var node = first
        repeat(size) {
            if (node?.item == element) {
                return true
            } else {
                node = node?.next
            }
        }
        return false
    }

    override fun iterator(): MutableIterator<T> {
        return object : MutableIterator<T> {

            private var nextNode = first
            private val currentModCount = modCount

            override fun hasNext(): Boolean {
                return nextNode != null
            }

            override fun next(): T {
                if (currentModCount != modCount) { throw ConcurrentModificationException() }
                return nextNode?.item!!.also {
                    nextNode = nextNode?.next
                }
            }

            override fun remove() {
                TODO("Not yet implemented")
            }
        }
    }

    fun checkIndex(index: Int) {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index: $index Size: $size")
        }
    }

    fun checkIndexForAdding(index: Int) {
        if (index < 0 || index > size) {
            throw IndexOutOfBoundsException("Index: $index Size: $size")
        }
    }

    class Node<T>(
        var prev: Node<T>? = null,
        val item: T,
        var next: Node<T>? = null
    )
}