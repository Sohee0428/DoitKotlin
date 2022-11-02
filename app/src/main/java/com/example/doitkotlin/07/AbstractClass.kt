package com.example.doitkotlin

abstract class AbstractClass {

}

abstract class Vehicle(val name: String, val color: String, val weight: Double) {
    abstract var maxSpeed: Double

    var year = "2022"

    abstract fun start()
    abstract fun stop()

    fun displaySpecs() {
        println("Name: $name, Color: $color, Weight: $weight, Year: $year, Max Speed: $maxSpeed")
    }
}

class MyCar(name: String, color: String, weight: Double, override var maxSpeed: Double) :
    Vehicle(name, color, weight) {
    override fun start() {
        println("Car Started")
    }

    override fun stop() {
        println("Car Stopped")
    }
}

class Motorcycle(name: String, color: String, weight: Double, override var maxSpeed: Double) :
    Vehicle(name, color, weight) {
    override fun start() {
        println("Bike Started")
    }

    override fun stop() {
        println("Bike Stopped")
    }
}

abstract class Printer {
    abstract fun print()
}

val myPrinter = object: Printer() {
    override fun print() {
        println("출력합니다.")
    }
}

//interface Pet {
//    var category: String
//    val msgTags: String
//    get() = "I'm your pet"
//
//    fun feeding()
//    fun patting() {
//        println("쓰다듬다.")
//    }
//}
//
//class Cat(val name: String, override var category: String) : Pet {
//    override fun feeding() {
//        println("먹이주기!")
//    }
//}
//
//open class Animal(val name: String)
//
//class Dog(name: String, override var category: String): Animal(name), Pet {
//    override fun feeding() {
//        println("강아지 사료")
//    }
//}
//
//class Master {
//    fun playWithPet(dog: Dog) {
//        println("강아지 ${dog.name}랑 놀기")
//    }
//    fun playWithPet(cat: Cat) {
//        println("고양지 ${cat.name}랑 놀기")
//    }
//}
//
//fun main() {
//    val master = Master()
//    val dog = Dog("yeppi", "Small")
//    val cat = Cat("mira","fat")
//    master.playWithPet(dog)
//    master.playWithPet(cat)
//}

interface Pet {
    var category: String
    val msgTags: String
        get() = "I'm your pet"
    var species: String

    fun feeding()
    fun patting() {
        println("쓰다듬다.")
    }
}

//open class Animal(val name: String)

//class Dog(name: String, override var category: String) : Animal(name), Pet {
//    override var species: String = "dog"
//    override fun feeding() {
//        println("강아지 밥!")
//    }
//}

//class Cat(name: String, override var category: String) : Animal(name), Pet {
//    override var species: String = "dog"
//    override fun feeding() {
//        println("고양이 밥!")
//    }
//}

class Master {
    fun playWithPet(pet: Pet) {
        println("Enjoy with may ${pet.species}")
    }
}

//fun main() {
//    val master = Master()
//    val dog = Dog("yeppi", "dog")
//    val cat = Cat("mira", "cat")
//
//    master.playWithPet(dog)
//    master.playWithPet(cat)
//}

interface Bird {
    val wings: Int
    fun fly()
    fun jump() {
        println("bird jump!")
    }
}

interface Horse {
    val maxSpeed: Int
    fun run()
    fun jump() {
        println("horse jump! max speed : $maxSpeed")
    }
}

class Pegasus: Bird, Horse {
    override val wings: Int = 2
    override val maxSpeed: Int = 100

    override fun fly() {
        println("fly!")
    }
    override fun run() {
        println("run")
    }
    override fun jump() {
        super<Horse>.jump()
        println("Pegasus Jump!")
    }
}

fun main() {
    val pegasus = Pegasus()
    pegasus.fly()
    pegasus.jump()
    pegasus.run()
}

interface A {
    fun functionA() {}
}

interface B {
    fun functionB() {}
}

class C(val a: A, val b: B) {
    fun functionC() {
        a.functionA()
        b.functionB()
    }
}

class DelegatedC(a: A, b: B): A by a, B by b {
    fun functionC() {
        functionA()
        functionB()
    }
}