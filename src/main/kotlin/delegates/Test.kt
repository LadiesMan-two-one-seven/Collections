// @file:OptIn(ExperimentalEncodingApi::class)

package delegates

import properties.encrypted
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// import kotlin.io.encoding.ExperimentalEncodingApi

fun main() {
    val user = User()
//    user.password = "123456"
//    println(user.password)
//
//    user.creditCardNumber = "2202 0000 0000 0000"
//    println(user.creditCardNumber)

    user.a = 10
}

class User {

    var a by observable(0) {old, new ->
        println("Old value: $old, New value: $new")
    }

    var password: String by encrypted()

    var creditCardNumber: String by encrypted()
}

fun <T> observable(
    initialValue: T,
    onChanged: (oldValue: T, newValue: T) -> Unit
) = ObservableProperty(initialValue, onChanged)

class ObservableProperty<T>(
    initialValue: T,
    private val onChanged: (oldValue: T, newValue: T) -> Unit
): ReadWriteProperty<Any, T> {

    private var currentValue: T = initialValue

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        return currentValue
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        val oldValue = currentValue
        currentValue = value
        onChanged(oldValue, value)
    }
}
