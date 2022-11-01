@file:JvmName("PackageLevel")
package com.example.doitkotlin

import android.widget.TextView
import java.util.*

//class StaticAndCompanion {
//}
//
//class People {
//    var id = 1
//    var name = "Sohee"
//
//    companion object {
//        var language = "Korean"
//        fun work() {
//            println("working...")
//        }
//    }
//}

//fun main() {
//    println(People.language)
//    People.language = "English"
//    println(People.language)
//    People.work()
//    People.name
//
//}

//class CCustomer {
//    companion object {
//        const val NAME = "KwonSoHee"
//        private val tset ="1"
//        @JvmStatic fun logout() {}
//    }
//}
//
//class Test {
//    private val test = CCustomer.NAME
//}
//
//object OCustomer {
//    @JvmStatic
//    fun login() {}
//}

//fun main() {
//    OCustomer.login()
//    CCustomer.logout()
//}

//fun packageLevelFunc() { }
//
//fun main() {
//    packageLevelFunc()
//}

object OCustomer {
    var name = "Sohee"
    fun greeting() = println("안녕")
    val HOBBY = Hobby("bowling")
}

class CCustomer {
    companion object {
        const val HELLO = "hello"
        var name = "Sanghun"
        @JvmField val HOBBY = Hobby("Basketball")
        @JvmStatic fun greeting() = println("hi")
    }
}

class Hobby(val hobby: String)

//fun main() {
//    OCustomer.greeting()
//    OCustomer.name = "KwonSoHee"
//    println(OCustomer.HOBBY.hobby)
//
//    CCustomer.greeting()
//    println(CCustomer.HOBBY.hobby)
//}

open class Superman() {
    fun work() { }
    open fun fly() { }
}

fun main() {
    val pretendedMan = object : Superman() {
        override fun fly() { }
    }
    pretendedMan.fly()
    pretendedMan.work()
}

fun foo() {
    val adHoc = object {
        var x: Int = 0
        var y: Int = 0
    }
    println(adHoc.x + adHoc.y)
}

//class C {
//    private fun foo() = object {
//        val x = "x"
//    }
//
//    fun publicFoo() = object {
//        val x = "x"
//    }
//
//    fun bar() {
//        val x1 = foo().x
////        val x2 = publicFoo().x
//    }
//}