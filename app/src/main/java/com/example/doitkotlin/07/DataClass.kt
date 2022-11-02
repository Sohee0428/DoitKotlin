package com.example.doitkotlin

class DataClass {
}

data class Customer(var name: String, var email: String) {
    var job: String = "Unknown"

    init {
        // 간단한 로직은 여기에
    }
}

//fun main () {
//    val cus1 = Customer("sohee", "sohee@illuminarean.com")
//    val cus2 = Customer("sohee", "sohee@illuminarean.com")
//    val cus3 = cus1.copy(name = "KwonSoHee")
//
//    println(cus3.name)
//    println(cus1 == cus2)
//    println(cus1.equals(cus2))
//    println("${cus1.hashCode()}, ${cus2.hashCode()}")
//
//    val (name, email1) = cus1
//    val (_, email2) = cus2
//    println("$name, $email1, $email2")
//
//    val name2 = cus2.component1()
//    val email3 = cus3.component2()
//    println("$name2, $email3")
//}

class Outer {
    val ov = 5
    class Nested {
        val nv = 10
//        fun greeting() = println("hello $ov")
        fun accessOuter() {
            println(country)
            getSomething()
        }
    }

    fun outside() {
//        val msg = Nested().greeting()
        println(Nested().nv)
    }

    companion object {
        const val country = "Korea"
        fun getSomething() = println("something")
    }
}

//fun main() {
//    val outout = Outer.Nested().greeting()
//    Outer.outside()
//    val outer = Outer()
//    outer.outside()
//}

class Smartphone(val model: String) {
    private val cpu = "Exyons"

    inner class ExternalStorage(val size: Int){
        fun getInfo() {
            println("model = $model, cup = $cpu, size = $size GB")
        }
    }

    fun powerOn(): String {
        class Led(val color: String) {
            fun blink(): String = "Blinking $color on $model"
        }
        val powerStatus = Led("White")
        return powerStatus.blink()
    }
}

//fun main() {
//    val mySmartphone = Smartphone("S22 Ultra").ExternalStorage(256)
//    mySmartphone.getInfo()
//
//    val myPhone = Smartphone("S22 Ultra")
//    myPhone.ExternalStorage(256)
//    println(myPhone.powerOn())
//}

interface Switcher {
    fun on(): String
}

class Smartphone2(val model: String) {
    fun powerOn(): String {
        class Led(val color: String) {
            fun blink(): String = "Blinking $color on $model"
        }
        val powerStatus = Led("White")
        val powerSwitcher = object : Switcher {
            override fun on(): String {
                return powerStatus.blink()
            }
        }
        return powerSwitcher.on()
    }
}

class Status: Result()
class Inside: Result.Success("Status")

sealed class Result {
    open class Success(val message: String): Result()
    class Error(val code: Int, val message: String): Result()
}

//fun main() {
//    val result = Result.Success("Good")
//    val msg = eval(result)
//    println(msg)
//    new()
//}

fun eval(result: Result): String = when(result) {
    is Status -> "in progress"
    is Result.Success -> result.message
    is Result.Error -> result.message
    is Inside -> "else"

}

sealed class Color {
    object Red: Color()
    object Green: Color()
    object Blue: Color()
}

val color : Color = Color.Red
val font = when (color) {
    is Color.Red -> {
        "Noto Sans"
    }
    is Color.Green -> {
        "Open Sans"
    }
    is Color.Blue -> {
        "Blue"
    }
}

enum class DayOfWeek(val num: Int) {
    MONDAT(1), TUESDAY(2), WENDESDAY(3), THURSDAY(4),
    FRIDAY(5), SATURDAY(6), SUNDAY(7);

    fun new() {

    }
}

val day = DayOfWeek.SUNDAY
fun new() {
    day.toString()
    when(day.num) {
        1,2,3,4,5 -> println("Weekday")
        6,7 -> println("Weekend")
    }
    val a = 1
    val b = 6

    println(a.rangeTo(b))
}

class Manager {
    operator fun invoke(value: String) {
        println(value)
    }
}

fun main() {
    val manager = Manager()
    manager("new")

    val point = Point(12, 23)
    println(-point)
}

data class Point(val z:Int, val b: Int)

operator fun Point.unaryMinus() = Point(-z, -b)
