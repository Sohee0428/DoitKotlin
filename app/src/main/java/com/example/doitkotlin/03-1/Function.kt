package com.example.doitkotlin.`03-1`

import android.widget.Toast
import java.math.BigInteger

class Function {

    fun sum(a: Int, b: Int): Int {
        var result = a + b
        return result
    }

    fun printSum(a: Int, b: Int): Unit {
        println("sum of $a and $b is ${a + b}")
    }
}

//fun main() {
//    numbers(x = 50, y = 30)
//    numbers(y = 0)
//    numbers(1,2,3)
//
//    val out: () -> Unit = {println("Hello World!")}
//
//    out()
//}

fun numbers(x: Int = 100, y: Int, z: Int = 90) {
}

//fun main() {
//    normalVarargs(1,2,3)
//    normalVarargs(4,5,6,7,8)
//}

fun normalVarargs(vararg count: Int) {
    for (num in count) {
        print("$num")
    }
}

//fun sum(): (Int, Int) -> Int {
//    return {x, y -> x + y}
//}

//fun main() {
//    val result1 = funcParam(3, 2, ::sum)
//    println(result1)
//
//    hello(::text)
//
//    val likeLambda = ::sum
//    println(likeLambda(6,6))
//}

fun sum(a: Int, b: Int) = a + b
fun text(a: String, b: String) = "Hi! $a, $b"
fun funcParam(a: Int, b: Int, c: (Int, Int) -> Int): Int {
    return c(a, b)
}

fun hello(body: (String, String) -> String): Unit {
    println(body("Hello", "World"))
}

//fun main() {
//    extensionFunc()
//    extensionFunc{
//        println("test")
//    }
//    noextensionFunc {
//        println("test")
//    }
//
//    test1()
//    test2()
//}

fun String.plusWorld(): String {
    return this + "World"
}

fun extensionFunc() {
    println("Hello".plusWorld())
}

inline fun extensionFunc(test: () -> Unit) {
    test.invoke()
}

fun noextensionFunc(test: () -> Unit) {
    test.invoke()
}

fun String?.notNull(body: String.() -> Unit) {
    this?.body()
}

fun test1() {
    "aaa".notNull {
        println("this message $this")
    }
}

inline fun test2() {
    "aaa".notNull {
        println("this message $this")
    }
}

tailrec fun factorial(n: Int, acc: Int): Int {
    return if (n <= 0) {
        acc
    } else {
        factorial(n - 1, n * acc)
    }
}

//fun main(args: Array<String>) {
//    println("factorial(10) : ${factorial(10, 1)}" )
//}

fun main() {
//    val n = 1
//    val first = BigInteger("0")
//    val second = BigInteger("1")
//
//    println(fibonacci(n, first, second))
//    var str: String? = "dsa"
//    str = null
//    val length = str?.length ?: -1
//    println(length)

    val multi: (Int, Int) -> Int = {a: Int, b:Int ->
        a + b
        a * b
    }
    print(multi(1, 2))
}

tailrec fun fibonacci(n: Int, a: BigInteger, b: BigInteger): BigInteger {
    return if (n == 0) a else fibonacci(n - 1, b, a + b)
}