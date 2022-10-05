package com.example.doitkotlin.`02-3`

class NullTest {
}

fun main() {
    var str1: String? = "Hello Kotlin"
    str1 = null

    val length = str1?.length ?: -1
    val a = 1
    when(a) {
        1 -> ""
    }
    if (a == 1) {

    }
}