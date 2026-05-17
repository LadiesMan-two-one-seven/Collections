package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `When 5 add to 10 then result 15`() {
        val result = calculator.add(5, 10)
        val expected = 15
        assertEquals(expected, result)
    }

    @Test
    fun `When 50 add to 100 then result 150`() {
        val result = calculator.add(50, 100)
        val expected = 150
        assertEquals(expected, result)
    }

    @Test
    fun `When subtract 50 from 100 then result 50`() {
        val result = calculator.subtract(100, 50)
        val expected = 50
        assertEquals(expected, result)
    }

    @Test
    fun `When subtract 100 from 50 then result -50`() {
        val result = calculator.subtract(50, 100)
        val expected = -50
        assertEquals(expected, result)
    }

    @Test
    fun `When 10 multiplication to 10 then tesult 100`() {
        val result = calculator.multiplication(10, 10)
        val expected = 100
        assertEquals(expected, result)
    }

    @Test
    fun `When 0 multiplication to 10 then result -100`() {
        val result = calculator.multiplication(0, 10)
        val expected = 0
        assertEquals(expected, result)
    }

    @Test
    fun `When 10 divide to 5 then result 2`() {
        val result = calculator.divide(10, 5)
        val expected = 2.0
        assertEquals(expected, result, 0.001)
    }

    @Test
    fun `When 0 divide to 10 then result 0`() {
        val result = calculator.divide(0, 10)
        val expected = 0.0
        assertEquals(expected, result, 0.001)
    }

//    @Test
//    fun test() {
//        var result = 0.0
//        repeat(100) {
//            result += 0.01
//        }
//        val expected = 1.0
//        assertEquals(expected, result, 0.001)
//    }
}