package com.example.doitkotlin.`05`

open class Bird(var name: String, var wing: Int = 2, var beak: String, var color: String) {

    fun fly() = println("날개를 $wing 개 가진 새가 날다.")
    open fun sing(beak: String) = println("부리가 $beak")
}

class Lark(name: String, wing: Int = 2, beak: String, color: String) : Bird(name, wing, beak, color){
    fun singHitone() = println("Happy!")
}

class Parrot(name: String, wing: Int, beak: String, color: String, val language: String) :
    Bird(name, wing, beak, color) {

    fun speak() = println("Speak $language")
    override fun sing(song: String) {
        super.sing(beak)
        println("앵무새가 부르는 노래 : $song")
    }
}

//fun main() {
//    val coco = Bird("비둘기", 2, "짧다.", "회색")
//    val lark = Lark("종달새", 2, "짧다.", "갈색")
//    val parrot = Parrot("앵무새", 2, "짧다.", "노란색", "한국말")
//
//    coco.fly()
//    lark.singHitone()
//    parrot.speak()
//    parrot.sing("좋은날")
//}

//fun main() {
//    val coco = Bird()
//    coco.color = "red"
//
//    val lulu = NewBird("앵무새", 2, "길다.", "white")
//
//    println("coco의 색은 ${coco.color}")
//    coco.fly()
//    coco.sing("길다.")
//}

class NewBird {
    var name: String
    var wing: Int
    var beak: String
    var color: String

    constructor(_name: String, _wing: Int, _beak: String, _color: String) {
        name = _name
        wing = _wing
        beak = _beak
        color = _color
    }

    constructor(_name: String, _color: String) {
        name = _name
        wing = 2
        beak = "짧다."
        color = _color
    }

    fun fly() = println("날개를 $wing 개 가진 새가 날다.")
    fun sing(beak: String) = println("부리가 $beak")
}

//fun main() {
//    val lulu = NewBird("앵무새", 2, "길다.", "white")
//    val yumi = NewBird("참새", "brown")
//
//    println("lulu 색은 ${lulu.color}")
//    println("yumi 색은 ${yumi.color}")
//
//    lulu.fly()
//    lulu.sing("길다.")
//}

//class OtherBird(_name: String, _wing: Int, _beak: String, _color: String) {
//    var name: String = _name
//    var wing: Int = _wing
//    var beak: String = _beak
//    var color: String = _color
//
//    fun fly() = println("날개를 $wing 개 가진 새가 날다.")
//    fun sing(beak: String) = println("부리가 $beak")
//}

//fun main() {
//    val nunu = OtherBird("갈매기", 2, "길다.", "black")
//
//    println("nunu 색은 ${nunu.color}")
//
//    nunu.fly()
//    nunu.sing("길다.")
//}

class OtherBird(var name: String, var wing: Int = 2, var beak: String, var color: String) {

    init {
        println("초기화 블록 시작!!")
        sing("짧다..")
    }

    fun fly() = println("날개를 $wing 개 가진 새가 날다.")
    fun sing(beak: String) = println("부리가 $beak")
}

//fun main() {
//    val nunu = OtherBird(name = "갈매기", beak = "길다.", color = "black")
//
//    println("nunu 색은 ${nunu.color}")
//
//    nunu.fly()
//    nunu.sing("길다.")
//}

open class Person {
    constructor(firstName: String) {
        println("[Person] $firstName")
    }
    constructor(firstName: String, age: Int) {
        println("[Person] $firstName, $age")
    }
}

class Developer: Person {
    constructor(firstName: String): this(firstName, 10) {
        println("[Developer] $firstName")
    }
    constructor(firstName: String, age: Int): super(firstName, age) {
        println("[Developer] $firstName, $age")
    }
}

//fun main() {
//    val sohee = Developer("sohee")
//
//    sohee
//}

open class Base {
    open val x: Int = 20
    open fun f() = println("Base Class")
}

class Child : Base() {
    override val x: Int = super.x +1
    override fun f() = println("Child Class")

    inner class Inside {
        fun f() = println("Inside Class")
        fun test() {
            f()
            Child().f()
            super@Child.f()
        }
    }
}

open class A {
    open fun f() = println("3")
    fun a() = println()
}

interface B {
    fun f() = println("2")
    fun b() = println()
}

//class C : A(), B {
//
//    fun test() {
//        f()
//        b()
//        super<A>.f()
//        super<B>.f()
//    }
//
//    override fun f() {
//        println("1")
//    }
//}

fun main() {
//    val c = C()
//    c.test()
}
