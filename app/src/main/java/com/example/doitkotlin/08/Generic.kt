package com.example.doitkotlin

import java.lang.IllegalStateException

class Generic {
}

class Box1<T>(t: T) {
    var name = t
}

class Box2(t: Any) {
    var name = t
}

//fun main() {
//    val box1: Box1<Int> = Box1<Int>(1)
//    box1.name
//    val box2 = Box1("Sohee")
//
//    val box3 = Box2("1")
//    (box3.name  as Int)
//    val box4 = Box2("Sohee")
//}

class MyClass1<T>( var myProp: T) {
}

class MyClass2<T> {
    var myProp: T
    constructor(_myProp: T) {
        this.myProp = _myProp
    }
}

val a = MyClass1<Int>(2)
val b = MyClass2<Int>(2)


open class Parent
class Child: Parent()
class Cup<T>

//fun main() {
//    val obj1: Parent = Child()
//    val obj2: Child = Parent()
//
//    val obj3: Cup<Parent> = Cup<Child>()
//    val obj4: Cup<Child> = Cup<Parent>()
//
//    val obj5 = Cup<Child>()
//    val obj6: Cup<Child> = obj5
//}

class GenericNull<T> {
    fun equalityFunc(arg1: T, arg2: T) {
        println(arg1?.equals(arg2))
    }
}

class GenericNotNull<T: Any> {

}

//fun main() {
//    val obj1 = GenericNull<String>()
//    obj1.equalityFunc("Hello", "World")
//
//    val obj2 = GenericNull<Int?>()
//    obj2.equalityFunc(null, 10)
//
//    val obj3 = GenericNotNull<Int?>()
//}

//fun <T> find(a: Array<T>, Target: T): Int {
//    for (i in a.indices) {
//        if (a[i] == Target) return i
//    }
//    return -1
//}
//
//fun main() {
//    val arr1: Array<String> = arrayOf("a", "b", "c", "d")
//    val arr2: Array<Int> = arrayOf(1, 2, 3, 4)
//
//    println(find<String>(arr1, "d"))
//    println(find(arr2, arr2))
//}

//fun <T> add(a: T, b: T): T {
//    return a + b
//}

fun <T> add(a: T, b: T, op: (T, T) -> T): T {
    return op(a,b)
}

//fun main() {
//    val result = add(2,3, {a, b -> a + b})
//}

class Calc<T: Number> {
    fun plus(arg1: T, arg2: T): Double {
        return arg1.toDouble() + arg2.toDouble()
    }
}

//fun main() {
//    val calc1 = Calc<Int>()
//    val calc2 = Calc<Long>()
//    val calc3 = Calc<Double>()
//    val calc4 = Calc<String>()
//}

fun <T: Number> addLimit(a: T, b: T, op: (T, T) -> T): T {
    return op(a, b)
}

//val result = addLimit("abc", "def", {a, b -> a + b})

interface InterfaceA
interface InterfaceB

class HandlerA: InterfaceA, InterfaceB
class HandlerB: InterfaceB

class ClassA<T> where T: InterfaceA, T: InterfaceB
//
//fun main() {
//    val obj1 = ClassA<HandlerA>()
//    val obj2 = ClassA<HandlerB>()
//}

fun <T> myMax(a: T, b: T): T where T: Number, T: Comparable<T> {
    return if (a > b) a else b
}

//class Box<T>(val size: Int)
//
//fun main() {
//    val anys: Box<Any> = Box<Int>(19)
//    val nothings: Box<Nothing> = Box<Int>(20)
//}

//class Box<out T>(val size: Int)
//
//fun main() {
//    val anys: Box<Any> = Box<Int>(19)
//    val nothings: Box<Nothing> = Box<Int>(20)
//}

//class Box<in T>(val size: Int)
//
//fun main() {
//    val anys: Box<Any> = Box<Int>(19)
//    val nothings: Box<Nothing> = Box<Int>(20)
//}


//class Box<out T: Animal>(private var element: T) {
//    fun getAnimal(): T = element
//}

class Box<out T : Animal>(val item: T) {
    fun getAnimal(): T = item
//    fun set(new: T) {
//    }
}

//class Box<in T : Animal>(var item: T) {
//    fun getAnimal(): T = item
//    fun set(new: T) {
//        item = new
//    }
//}

open class Fruit
class Apple : Fruit()
class Banana : Fruit()

//fun receiveFruits(fruits: Array<Fruit>) {
//    println("Number of fruits: ${fruits.size}")
//}

//fun main() {
//    val fruits: Array<Apple> = arrayOf(Apple())
//    receiveFruits(fruits)
//    var fruit = arrayOf(Fruit())
//    var apple = arrayOf(Apple())
//    fruit = apple
//
//}

open class Animal(val size: Int) {

}

class Cat(val jump: Int): Animal(50)

fun printObj(box: Box<out Animal>) {
    val obj: Animal = box.item
    println(obj)
//    box.item = Animal(1)
}


//fun main() {
//    val animal: Box<Animal> = Box(Animal(6))
//    val cat: Box<Cat> = Box(Cat(7))
//
//    printObj(animal)
//    printObj(cat)
//}

class InOutTest<in T, out U>(t: T, u: U) {
//    val propT: T = t
    val propU: U = u

    fun func1(t: T) {}
//    fun func2(u: U) {}
}

fun starTestFunc(v: InOutTest<*, *>) {
//    v.func1(1)
    println(v.propU)
}


//fun main() {
//    val result = getType<Float>(10)
//    println(result)
//}

inline fun <reified T> getType(value: Int): T {
    println(T::class)
    println(T::class.java)

    return when (T::class) {
        Float::class -> value.toFloat() as T
        Int::class -> value as T
        else -> throw IllegalStateException("error")
    }
}

class Box5<T>(t: T) {
    var name = t
}

val str1: Box5<String> = Box5<String>("ed")
val str2 = Box5("ed")
val str3 = Box5<String>("ed")
//val str4: String = Box5("ed")