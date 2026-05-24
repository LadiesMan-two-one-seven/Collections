package collections

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MyHashSetTest {

    private val numbers = MyHashSet<Int>()

    @Test
    fun `When added 100 elements Than size 100`() {
        repeat(100) {
            numbers.add(it)
        }
        assertEquals(100, numbers.size)
    }

    @Test
    fun `When added 10 similar elements Then size 1`() {
        repeat(10) {
            numbers.add(0)
        }
        assertEquals(1, numbers.size)
    }

    @Test
    fun `When adding is succeed Then method return true`() {
        assertTrue { numbers.add(0) }
    }

    @Test
    fun `When adding is failed Then method return false`() {
        numbers.add(0)
        assertFalse { numbers.add(0) }
    }

    @Test
    fun `When element is absent in set Then method return true`() {
        numbers.add(0)
        assertTrue { numbers.contains(0) }
    }

    @Test
    fun `When element doest present in set Then method return false`() {
        numbers.add(0)
        assertFalse { numbers.contains(1) }
    }

    @Test
    fun `When removed element Then size is decreased`() {
        repeat(10) {
            numbers.add(it)
        }
        numbers.remove(0)
        assertEquals(9, numbers.size)
    }

    @Test
    fun `When element removed Then contains return false`() {
        repeat(10) {
            numbers.add(it)
        }
        numbers.remove(0)
        assertFalse { numbers.contains(0) }
    }

    @Test
    fun `When set is cleared Then size is 0`() {
        repeat(10) {
            numbers.add(it)
        }
        numbers.clear()
        assertEquals(0, numbers.size)
    }

    @Test
    fun `When set is cleared Then all elements is absent`() {
        repeat(10) {
            numbers.add(it)
        }
        numbers.clear()
        repeat(10) {
            assertFalse { numbers.contains(it) }
        }
    }
}