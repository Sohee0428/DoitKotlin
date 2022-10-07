package com.example.doitkotlin.`02-3`

class NullTest {
}

fun main() {
    var str1: String? = "Hello Kotlin" as? String

    println(str1?.length)
    println(str1!!.length)
    println(str1!!.length)


    val length = str1?.length ?: -1
    val a = 1
    when(a) {
        1 -> ""
    }
    if (a == 1) {

    }
}