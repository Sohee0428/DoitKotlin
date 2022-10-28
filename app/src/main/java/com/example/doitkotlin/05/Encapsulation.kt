package com.example.doitkotlin

class Encapsulation {

}

private class PrivateClass {
    private var i = 1
    private fun privateFunc() {
        i += 1
    }
    fun access() {
        privateFunc()
    }
}

class OtherClass {
//    val opc = PrivateClass()
    fun test() {
        val pc = PrivateClass()
//    pc.i
    }
}

//fun main() {
//    val pc = PrivateClass()
//    pc.i
//    pc.privateFunc()
//}

fun topFunction() {
    val pc = PrivateClass()
}

//open class Base {
//    protected var i = 1
//    protected fun protectedFunc() {
//        i += 1
//    }
//    fun accss() {
//        protectedFunc()
//    }
//    protected class Nested
//}
//
//class Derived : Base() {
//    fun test(): Int {
//        protectedFunc()
//        return i
//    }
//}
//
//fun main() {
//    val base = Base()
//    base.i
//    base.protectedFunc()
//    base.accss()
//}

open class Base {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4

    protected class Nested {
        public val e: Int = 5
        private val f: Int = 6
    }
}

class Derived : Base() {
    public override val b: Int = 7
}

class Other(base: Base) {
}