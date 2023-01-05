package com.example.doitkotlin.`11`

import com.example.doitkotlin.flow.ArticleHeadline
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class NewsRemoteDataSource(
    private val newsApi: NewsApi,
    private val refreshIntervalMs: Long = 5000
) {
    val latestNews: Flow<List<ArticleHeadline>> = flow {
        while(true) {
            val latestNews = newsApi.fetchLatestNews()
            emit(latestNews) // Emits the result of the request to the flow
            delay(refreshIntervalMs) // Suspends the coroutine for some time
        }
    }
}

// Interface that provides a way to make network requests with suspend functions
interface NewsApi {
    suspend fun fetchLatestNews(): List<ArticleHeadline>
}

fun main(): Unit = runBlocking {
    val startTime = System.currentTimeMillis()

    val test: Flow<String> = flow<String> {
        val text = text()
        emit(text)
        println("출력!!")

        delay(4000)

        val endTime = System.currentTimeMillis()
        println("걸린 시간은? ${endTime - startTime}")
    }.map {
        it.length.toString()
    }.catch {
        emit("error")
    }

    launch {
        test.collect {
            println(it)
        }
    }
}

 suspend fun text(): String {
     delay(2000)
     return "2초 지났다아아"
}