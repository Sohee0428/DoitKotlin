package com.example.doitkotlin.`09`

import java.util.ArrayList

class Collection {
}

//fun main() {
//    val list1 = listOf("one", "two", "three")
//    val list2 = listOf(1, 2, 3)
//    val map1 = mapOf("hi" to 1, "hello" to 2)
//
//    println(list1 + "four")
//    println(list2 + 4)
//    println(list2 + listOf(5, 6))
//    println(list2 - 1)
//    println(list2 - listOf(2, 3))
//    println(map1 + Pair("bye", 3))
//    println(map1 - "hi")
//    println(map1 + mapOf("my" to 4, "name" to 5))
//    println(map1 - listOf("hi", "hello"))
//
//    println(list2.sum())
//    val listPair = listOf(Pair("d", 100), Pair("D", 393))
//    println(listPair.sumOf { it.second })
//
//    val list = listOf(1, 2, 3, 4, 5, 6)
//    val map = mapOf(1 to "one", 2 to "two", 3 to "three", 4 to "four")
//
//// forEach: 각 요소를 람다식으로 처리
//    list.forEach { println(it) }
//// onEach: 각 요소를 람다식으로 처리 후 컬렉션으로 반환
//    val returnedList = list.onEach { println(it) }
//// count: 조건에 맞는 요소 개수 반환
//    println(list.count { it % 2 == 0 })
//
//// max/min: 최댓값 요소와 최솟값 요소의 반환
//    println(list.minOrNull())
//    println(list.maxOrNull())
//// maxBy/minBy: 최댓값과 최솟값으로 나온 요소 it에 대한 식의 결과
//    println(map.maxOf { it.key })
//    println(map.minOf { it.key })
//
//// fold: 초깃값과 정해진 식에 따라 처음 요소부터 끝 요소에 적용하며 값을 생성
//    println(list.fold(4) { total, next -> total + next })
//// foldRight: fold와 같고 마지막 요소에서 처음 요소로 반대로 적용
//    println(list.foldRight(4) { total, next -> total + next })
//// reduce: fold와 동일하지만 초깃값을 사용하지 않음
//    println(list.reduce { total, next -> total + next })
//    println(list.reduceRight { total, next -> total + next })
//
//    println(list.all { it < 10 })
//    println(list.any { it > 10 })
//    println(list.contains(2))
//    println(2 in list)
//    println(list.containsAll(listOf(1, 2, 3)))
//    println(list.none())
//    println(list.isEmpty())
//    println(list.isNotEmpty())
//
//
//}

fun new() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val map = mapOf(1 to "one", 2 to "two", 3 to "three", 4 to "four")
    val listMixed = listOf(1, "two", 3, "four", 5.00)

    // filter: 식에 따라 요소를 골라내기
    list.filter{ it % 2 == 0 }
    list.filterNot{ it % 2 == 0 }
// filterNotNull: null을 제외한 요소 골라내기
    list.filterNotNull()
// filterIndexed: 인덱스와 함께 추출
    list.filterIndexed{ idx, value -> idx != 1 && value % 2 == 0 }
// filterIndexedTo: 추출 후 가변형 컬렉션으로 변환
    val mutList = list.filterIndexedTo(mutableListOf()) {idx, value -> idx != 1 && value % 2 == 0 }
// filterKeys/filterValues: Map의 키, 값에 따라 추출
    map.filterKeys{ it != 12 }
    map.filterValues{ it == "one" }
// filterIsInstance: 여러 자료형의 요소 중 원하는 자료형을 골라냄
    listMixed.filterIsInstance<String>()

//    mutableListOf<>()
//    arrayListOf<>()
//    ArrayList

    val animal = mutableSetOf("Lion", "Dog", "Cat", "Hippo")
    val capitalCityMap = mutableMapOf("Korea" to "Seoul", "China" to "Beijing")
}

//fun main() {
//    val list = listOf(6, 1, 2, 3, 4, 5, 6)
//
//
//    println(list.drop(2))
//    println(list.dropWhile{ it < 3 })
//    println(list.dropLastWhile{ it < 3 })
//    println(list.dropLast(2))
//    println(list.groupBy{ if(it % 2 == 0) "even" else "odd" })
//}

//fun main() {
//    val list = listOf(1, 2, 3, 4, 5, 6)
//
//    println(list.elementAt(1))
//    println(list.elementAtOrElse(10) { 2 * it })
//    println(list.elementAtOrNull(10))
//}

fun new3() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val listPair = listOf(Pair("a", 1), Pair("b", 2), Pair("c", 3), Pair("d", 1))

    // indexOf: 주어진 요소에 일치하는 첫 인덱스 반환
    list.indexOf(4)
// indexOfFirst: 람다식에 일치하는 첫 요소의 인덱스 반환, 없으면 -1
    list.indexOfFirst { it % 2 == 0 }
// lastIndexOf: 주어진 요소에 일치하는 가장 마지막 인덱스 반환
    list.lastIndexOf(4)
// indexOfLast: 람다식에 일치하는 마지막 요소의 인덱스 반환, 없으면 -1
    list.indexOfLast { it % 2 == 0 }

// single/singleOfNull: 람다식에 일치하는 요소 하나 반환
// 일치하는 요소가 하나 이상인 경우 예외 발생
    listPair.single { it.second == 100 }

// binarySearch: 요소에 대해 이진 탐색 후 인덱스 반환
    list.binarySearch(3)
// find: 조건식에 만족하는 첫 번째 검색된 요소 반환, 없으면 null
    list.find { 4 > it }
}

fun new4() {
    val unsortedList = listOf(3, 2, 7, 5)

// reversed: 뒤집힌 순서로 컬렉션 반환
    unsortedList.reversed()
// 결과값 [5,7,2,3]

// sorted: 요소를 정렬한 후 정렬된 컬렉션 반환
    unsortedList.sorted()
// 결과값 [2,3,5,7]

// sortedDescending: 내림차순 정렬
    unsortedList.sortedDescending()
// 결과값 [7,5,3,2]

// sortedBy/sortedByDescending: 특정 비교식에 의해 정렬된 컬렉션 반환
    unsortedList.sortedBy { it % 3 }
// 결과값 [3,7,2,5]
    unsortedList.sortedByDescending { it % 3 }
// 결과값 [2,5,7,3]
}

//fun main() {
//    val nums: Sequence<Int> = generateSequence(1) {it + 1}
//
//// take()를 사용해 원하는 요소 개수만큼 획득하고 toList()를 사용해 List 컬렉션으로 반환
//    println(nums.take(5).toList())
//// 결과값 [1, 2, 3, 4, 5]
//
//    val numsMap = generateSequence(1) {it + 1}.map{it * it}
//    println(numsMap.take(5).toList())
//// 결과값 [1,4,9,16,25]
//
//    val numsFilter = numsMap.filter{it % 2 == 0}
//    println(numsFilter.take(5).toList())
//}

fun main() {
    val list = listOf(1, 2, 3, 4, 5)
    val listSeq = list.asSequence()
        .map{ print("map($it) "); it * it }
        .filter { println("filter($it) "); it % 2 == 0 }
        .toList()

    println(listSeq)

    val arr = arrayOf(1, 2, 3, 4, 5)
    arr.forEach { element -> print(element) }
    arr.forEachIndexed { i, e -> println("arr[$i] = $e") }
}