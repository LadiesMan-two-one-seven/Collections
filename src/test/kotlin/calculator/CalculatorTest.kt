package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 5 add to 10 then result 15`(calculator: Calculator) {
        val result = calculator.sum(5, 10)
        val expected = 15
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 50 add to 100 then result 150`(calculator: Calculator) {
        val result = calculator.sum(50, 100)
        val expected = 150
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When subtract 50 from 100 then result 50`(calculator: Calculator) {
        val result = calculator.subtract(100, 50)
        val expected = 50
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When subtract 100 from 50 then result -50`(calculator: Calculator) {
        val result = calculator.subtract(50, 100)
        val expected = -50
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 10 multiplication to 10 then tesult 100`(calculator: Calculator) {
        val result = calculator.multiplication(10, 10)
        val expected = 100
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 0 multiplication to 10 then result -100`(calculator: Calculator) {
        val result = calculator.multiplication(0, 10)
        val expected = 0
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 10 divide to 5 then result 2`(calculator: Calculator) {
        val result = calculator.division(10, 5)
        val expected = 2.0
        assertEquals(expected, result, 0.001)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 0 divide to 10 then result 0`(calculator: Calculator) {
        val result = calculator.division(0, 10)
        val expected = 0.0
        assertEquals(expected, result, 0.001)
    }

    companion object {

        @JvmStatic
        fun calculatorsSource() = listOf(SimpleCalculator(), LoggingCalculator())
    }
}
