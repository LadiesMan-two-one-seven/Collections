package calculator

class LoggingCalculator: Calculator {

    override fun sum(a: Int, b: Int): Int {
        val result = a + b
        println("Operation: sum($a, $b). Result: $result)")
        return result
    }

    override fun subtract(a: Int, b: Int): Int {
        val result = a - b
        println("Operation: subtract($a, $b). Result: $result)")
        return result
    }

    override fun multiplication(a: Int, b: Int): Int {
        val result = a * b
        println("Operation: multiplication($a, $b). Result: $result)")
        return result
    }

    override fun division(a: Int, b: Int): Double {
        val result = a / b.toDouble()
        println("Operation: division($a, $b). Result: $result)")
        return result
    }
}
