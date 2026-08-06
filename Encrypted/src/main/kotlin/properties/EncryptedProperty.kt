// @file:OptIn(ExperimentalEncodingApi::class)

package properties

import kotlin.io.encoding.Base64
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// import kotlin.io.encoding.ExperimentalEncodingApi

fun encrypted() = EncryptedProperty()

class EncryptedProperty internal constructor(): ReadWriteProperty<Any, String> {

    private var encryptedValue: String = ""

    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        println("Getting value, encoded: $encryptedValue")
        val decoded = String(Base64.decode(encryptedValue))
        println("Get value, decoded: $decoded")
        return decoded
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        println("New value: $value")
        val encoded = Base64.encode(value.toByteArray())
        println("New value: $encoded")
        encryptedValue = encoded
    }
}

fun String.encode(): String {
    return Base64.encode(this.toByteArray())
}