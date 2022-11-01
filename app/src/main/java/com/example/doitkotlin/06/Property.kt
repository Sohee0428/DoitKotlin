package com.example.doitkotlin

import java.lang.AssertionError

class Property {

}
//class User(_id: Int, _name: String) {
//    val id: Int = _id
//        get() = field
//        set(value) {
//            field = value
//        }
//
//    var name: String = _name
//        get() = field
//        set(value) {
//            field = value
//    }
//}
//
//fun main() {
//    val user = User(10, "SoHee")
//    user.id = 3
//    user.name = "KwonSoHee"
//    println("user name : ${user.name}")
//}

class User(_id: Int, _name: String) {
    val id: Int = _id

    var name: String = _name
       private set(value) {
            println("the name was changed")
            field = value.uppercase()
        }
    fun new() {
        name = "he"
    }
}

//fun main() {
//    val user = User(1, "sohee")
//    println(user.name)
//    user.name
//}
//
//class User(_id: Int, _name: String) {
//    val id: Int = _id
//    private var tempName: String? = null
//    var name: String = _name
//        get() {
//            if (tempName == null) tempName = "NONAME"
//            return tempName ?: throw AssertionError("Asserted by others")
//        }
//}

open class First {
    open val x = 0
    get() {
        println("First x")
        return field
    }
}

class Second: First() {
    override var x = 0
    get() {
        println("Second x")
        return field +3
    }
}

//fun main() {
//    val second = Second()
//    println(second.x)
//}

class Person {
    lateinit var name: String
}

//fun main() {
//    val sohee = Person()
//    println(sohee.name)
//}

class LazyTest{
    val subject by lazy {
        "hello"
    }
    val newSubject = lazy {
        "world"
    }
}

//fun main() {
//    val test = LazyTest()
//    println(test.subject)
//    println(test.newSubject.value)
//}

interface Car {
    fun go(): String
}

class VanImpl(val power: String): Car {
    override fun go() = "짐을 적재하며 $power 를 가집니다."
}

open class SportImpl(val power: String): Car {
    override fun go() = "경주용에 사용하며 $power 를 가집니다."
}

class NewCar : SportImpl("test") {

}

class CarModel(val model: String, impl: Car): Car by impl {

    fun carInfo() {
        println("$model : ${go()}")
    }
}

//fun main() {
//    fun test(car: Car) {
//
//    }
//    val damas = CarModel("Damas", VanImpl("100"))
//    val my350z = CarModel("350Z", SportImpl("350"))
//    test(damas)
//    damas.carInfo()
//    my350z.carInfo()
//}

interface Worker {
    fun work()
    fun takeVacation()
}

open class JavaProgrammer : Worker {
    override fun work() = println("code with Java")
    override fun takeVacation() = println("code at the beach")
}

class PythonProgrammer : Worker {
    override fun work() = println("code with Python")
    override fun takeVacation() = println("code at the home")
}

class Manager1 : JavaProgrammer()
class Manager2(val worker: Worker) {
    fun work() = println("just manager")
    fun takeVacation() = worker.takeVacation()
}
class Manager3(val worker: Worker) : Worker by PythonProgrammer() {
    override fun work() = println("just manager")
    override fun takeVacation() = worker.takeVacation()
}

fun main() {
    val manager1 = Manager1()
    val manager2 = Manager2(PythonProgrammer())
    val manager3 = Manager3(PythonProgrammer())

    manager1.work()
    manager1.takeVacation()
    manager2.work()
    manager2.takeVacation()
    manager3.work()
    manager3.takeVacation()

    val javaCorder: JavaProgrammer = manager1
//    val pythonCorder: PythonProgrammer = manager3
}