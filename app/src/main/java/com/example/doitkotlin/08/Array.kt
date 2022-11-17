package com.example.doitkotlin

import java.util.*

class Array {
    val array1 = arrayOf(1, 2, 3)
    val array2 = arrayOf(4, 5, 6)
    val array3 = arrayOf(7, 8, 9)

    val array4 = arrayOf(array1, array2, array3)
    val array5 = arrayOf(arrayOf(1, 2, 3), arrayOf(4, 5, 6), arrayOf(7, 8, 9))

    fun new() {
        for (e1 in array5) {
            for(e2 in e1) {
                println(e2)
            }
        }

        val arr = intArrayOf(1, 2, 3, 4, 5)
        val arr1 = arrayOf(arrayOf(1, 2, 3), arrayOf(4, 5, 6))


        println("arr = ${arr.contentToString()}")
        println("size = ${arr.size}")
        println("sum = ${arr.sum()}")

        println("arr1 = ${arr1.contentDeepToString()}")
        println("${array1.contains(2)}, ${2 in array1}")
    }

    val intOnlyArray1 = arrayOf<Int>(1, 2, 3, 4)
    val intOnlyArray2 = intArrayOf(5, 6, 7, 8)

    fun test () {
        val hello = "Hello"
        hello[1]
//        hello[1] = 'd'
        var world = "world"
        world = "hello world"

        var s = StringBuilder("Hello")
        s[2] = 'e'
        s.append("new")
        println(s)
    }


}

fun main() {
    val fruits = arrayOf("banana", "apple", "orange", "kiwi")

    fruits.filter{ it.contains("a") }
        .sortedBy{ it }
        .forEach{ println(it)}

    val text = """
        |hello my name is sohee
        |hello my name is sanghoon
    """.trimMargin()

    println(text)

    Array().test()

    val hello = "hello my name is sohee"
    println(hello.split(" "))
}