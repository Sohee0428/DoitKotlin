package com.example.doitkotlin.`03-1`

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

fun numbers(x: Int =100, y: Int, z: Int = 90) {
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

fun main() {
    val result1 = funcParam(3, 2, ::sum)
    println(result1)

    hello(::text)

    val likeLambda = ::sum
    println(likeLambda(6,6))
}

fun sum(a: Int, b: Int) = a + b
fun text(a: String, b: String) = "Hi! $a, $b"
fun funcParam(a: Int, b: Int, c: (Int, Int) -> Int): Int {
    return c(a, b)
}
fun hello(body: (String, String) -> String): Unit {
    println(body("Hello", "World"))
}