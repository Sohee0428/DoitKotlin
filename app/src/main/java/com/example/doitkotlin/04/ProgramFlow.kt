package com.example.doitkotlin.`04`

class ProgramFlow {

    fun test() {
        val a = 4
        val b = 10
        var max = if (a > b) a else b

        val number = 0

        val result = if (number > 0)
            "양수 값"
        else if (number < 0)
            "음수 값"
        else "0"
    }

    fun test1() {
        val score = readLine()!!.toDouble()

        print(score)
    }
}

fun test1() {
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit
        print(it)
    }
    print(" done with explicit label")
}

fun test2() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return
        print(it)
    }
    print(" done with explicit label")
}

fun main() {
//    val score = readLine()!!.toInt()
//    var grade = if (90 < score) "A"
//    else if (80 < score) "B"
//    else "F"
//
//    print("score : $score, grade : $grade")
//
//    val str = "안녕하세요!"
//    val result = when(str) {
//        is String -> "문자열입니다."
//        else -> false
//    }
//    print(result)
//
//    var score = readLine()!!.toInt()
//    var grade = 'A'
//
//    when {
//        score > 90 -> grade = 'A'
//        score in 81..90 -> grade = 'B'
//        score in 71..80 -> grade = 'C'
//        score < 70 -> grade = 'F'
//    }
//
//    for (i in 5..1) print(i)
//    for (i in 5 downTo 1) print(i)

//    val n = readLine()!!.toInt()
//    for (line in 1..n){
//        for (space in 1..(n - line)) print("")
//        for (star in 1..(2 * line - 1)) print("*")
//        println()
//    }


    for (i in 1..5) {
        if (i == 3) break
        print(i)
    }

    println()

    for (i in 1..5) {
        if (i == 3) continue
        print(i)
    }

    val a = 6
    val b = 1
    val c: Int

    try {
        if(a * b > 0) {
            throw Exception()
        }
    } catch(e: Exception) {
        println("예외 발생")
    } finally {
        println("항상 호출됨")
    }
}

class InvalidNameException(message: String) : java.lang.Exception(message)