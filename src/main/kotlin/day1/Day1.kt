package day1

import java.io.*

fun main() {
    partA()
    partB()
}

fun partA() {
    val input = File("./src/main/kotlin/day1/input-day-one.txt").readLines()
    var num = 0
    val list = mutableListOf<Int>()
    input.forEach {
        if (it.isBlank()) {
            list.add(num)
            num = 0
        } else {
            num += it.toInt()
        }
        
    }

    println(list.sortedDescending().first())
}

fun partB() {
    val input = File("input-day-one.txt").readLines()
    var num = 0
    val list = mutableListOf<Int>()
    input.forEach {
        if (it.isBlank()) {
            list.add(num)
            num = 0
        } else {
            num += it.toInt()
        }
        
    }

    val sorted = list.sortedDescending()

    println(sorted.get(0) + sorted.get(1) + sorted.get(2))
}