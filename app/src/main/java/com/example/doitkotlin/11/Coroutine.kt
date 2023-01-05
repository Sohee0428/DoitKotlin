package com.example.doitkotlin

import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.actor
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

class Coroutine: AppCompatActivity() {

    fun collector() {

    }

    suspend fun new() {
        delay(122)
    }
}

//fun main() {
//    GlobalScope.launch {
//        delay(1000)
//        println("hello")
//    }
//    println("Hi!")
//    Thread.sleep(2000)
//}

//fun main() {
//    val job = GlobalScope.launch {
//        delay(1000L)
//        println("World")
//    }
//    println("Hello")
//    println("job.isActivity: ${job.isActive}, completed: ${job.isCompleted}")
//    Thread.sleep(2000L)
//    println("job.isActivity: ${job.isActive}, completed: ${job.isCompleted}")
//}

suspend fun doWork1(): String {
    delay(1000L)
    return "Work1"
}

suspend fun doWork2(): String {
    delay(3000L)
    return "Work2"
}

private fun worksInParallel() {
    val one = GlobalScope.async {
        doWork1()
    }
    val one2 = GlobalScope.launch {
        doWork1()
    }

    val two = GlobalScope.async {
        doWork2()
    }

    GlobalScope.launch {
        val one = one.await()
        val two = two.await()
        val combined = one + "_" + two
        val currentTime = System.currentTimeMillis()
        println("one -> $one : $currentTime")
        println("two -> $two : $currentTime")

        println("걸린 시간 : ${System.currentTimeMillis() - currentTime}")
        println("Kotlin Combined : $combined")
    }

    fun launch1() {
//        val job = async(start = CoroutineStart.LAZY) { doWork1 }
//        job.start()
//        val job = GlobalScope.launch(start = CoroutineStart.DEFAULT) {}
    }
}

//fun main() {
//    worksInParallel()
//    Thread.sleep(4000)
//}

val threadPool = Executors.newFixedThreadPool(4)
val muContext = threadPool.asCoroutineDispatcher()

//fun main() {
//    GlobalScope.launch {
//        delay(1000)
//        println("World!")
//    }
//    println("Hello!")
//    Thread.sleep(2000)
//    println("end!")
//
//}

//fun main() = runBlocking {
//    launch {
//        delay(1000)
//        println("World!")
//    }
//    println("Hello!")
//}

//fun main() = runBlocking {
//    val job = launch {
//        delay(1000)
//        println("World")
//    }
//    println("Hello")
//    job.join()
//}

//fun main() = runBlocking {
//    val time1 = measureTimeMillis {
//        val one = async { doWork1() }
//        val two = async { doWork2() }
//        println("AWAIT1: ${one.await()}_${two.await()}")
//    }
//    println("Completed in $time1")
//    val time2 = measureTimeMillis {
//        val one = async(start = CoroutineStart.LAZY) { doWork1() }
//        val two = async(start = CoroutineStart.LAZY) { doWork2() }
//        val combine = "${one.await()} + ${two.await()}"
//        println("AWAIT2: $combine")
//    }
//    println("Completed1 in $time2")
//}

//fun main() = runBlocking {
//    val job = List(100000) {
//        launch {
//            delay(100)
//            print(".")
//        }
//    }
//    job.forEach { it.join() }
//    println("complete")
////    sequence {
////        var a = 0
////        yield()
////    }
//}

//fun main() = runBlocking {
//    val jobs = arrayListOf<Job>()
//    jobs += launch(Dispatchers.Unconfined) {
//        println("Unconfined ${Thread.currentThread().name}")
//    }
//    jobs += launch(coroutineContext) {
//        println("coroutineContext ${Thread.currentThread().name}")
//    }
//    jobs += launch(Dispatchers.Default) {
//        println("Default ${Thread.currentThread().name}")
//    }
//    jobs += launch(Dispatchers.IO) {
//        println("IO ${Thread.currentThread().name}")
//    }
//    jobs += launch {
//        println("launch ${Thread.currentThread().name}")
//    }
//    jobs += launch(newSingleThreadContext("MyThread")) {
//        println("MyThread ${Thread.currentThread().name}")
//    }
//    jobs.forEach { it.join() }
//}

//fun main() = runBlocking {
//    GlobalScope.launch {
//        repeat(1000) { i ->
//            println("I'm sleeping $i ....")
//            delay(500)
//        }
//    }
//    delay(1300)
//}

fun main() = runBlocking {
    val job = launch {
        repeat(1000) { i ->
            println("I'm sleeping $i ....")
            delay(500)
        }
    }
    delay(1300)
    job.cancel()
}

//fun main() = runBlocking {
//    val job = launch {
//        try {
//            repeat(1000) { i ->
//                println("I'm sleeping $i ....")
//                delay(500)
//            }
//        } finally {
//            println("Finish")
//        }
//    }
//    delay(1300)
//    job.cancelAndJoin()
//}

//fun main() = runBlocking {
//    val job = launch {
//        try {
//            repeat(1000) { i ->
//                println("I'm sleeping $i ....")
//                delay(500)
//            }
//        } finally {
//            withContext(NonCancellable) {
//                println("I'm running...")
//                delay(1000)
//                println("Non-Cancellable")
//            }
//        }
//    }
//    delay(300)
//    println("Finish")
//    job.cancelAndJoin()
//}

//fun main() = runBlocking {
//    val startTime = System.currentTimeMillis()
//    val job = GlobalScope.launch {
//        var nextPrintTime = startTime
//        var i = 0
//        while (isActive) {
//            if (System.currentTimeMillis() >= nextPrintTime) {
//                println("I'm sleeping ${i++} ...")
//                nextPrintTime += 500L
//            }
//        }
//    }
//    delay(1300)
//    println("not-Finish")
//    job.cancelAndJoin()
//    println("Finish")
//}

//fun main() = runBlocking {
//        withTimeout(1200) {
//            repeat(1000) { i ->
//                println("I'm sleeping $i ...")
//                delay(500)
//            }
//    }
//}

//fun main() = runBlocking{
//    val one = GlobalScope.async {
//        doWork1()
//    }
//    val one2 = GlobalScope.launch {
//        doWork1()
//    }
//
//    println("${one.await()}, $one2")
//
//    val channel = Channel<Int>()
//    launch {
//        for (x in 1..5) channel.send(x*x)
//        channel.close()
//    }
//    for (element in channel) println(element)
////    repeat(5) { println(channel.receive())}
//    println("Done!")
//
//    data class Task (val desc: String)
//
//    val me = actor<Task>{
//        while (!isClosedForReceive) {
//            println(receive().desc.repeat(5))
//        }
//    }

suspend fun new1() {
    CoroutineScope(Dispatchers.Main).launch {

        val result = withContext(Dispatchers.IO) {
        }
    }
}

//suspend fun main() {
//    val job = CoroutineScope(Dispatchers.IO).launch(start = CoroutineStart.LAZY) {
//        println("시작!")
//    }
//    job.join()
//}



