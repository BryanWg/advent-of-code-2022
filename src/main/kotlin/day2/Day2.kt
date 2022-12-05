package day2

import java.io.*

fun main() {
    partA()
    partB()
}

fun partA() {
    val shapeScore = mapOf(
        Pair("X", 1),
        Pair("Y", 2),
        Pair("Z", 3),
    )

    val input = File("./src/main/kotlin/day2/input-day-two.txt").readLines()
    var totalScore = 0
    val strategies  = input.map { 
            it.split("\\s+".toRegex()).let { move ->
                Pair(move[0], move[1])
            }
        }

    strategies.forEach {
        totalScore += shapeScore.getValue(it.second) 
        totalScore += calculateScore(it)
    }

    println(totalScore)
}

fun calculateScore(strategy: Pair<String, String>): Int {
    val win = listOf(
        Pair("A", "Y"),
        Pair("B", "Z"),
        Pair("C", "X"),
    )
    val lose = listOf(
        Pair("A", "Z"),
        Pair("B", "X"),
        Pair("C", "Y"),
    )

    if (strategy in win) return 6
    if (strategy in lose) return 0
    return 3
}

fun partB() {
    val outComeScore = mapOf(
        Pair("X", 0),
        Pair("Y", 3),
        Pair("Z", 6),
    )

    val input = File("./src/main/kotlin/day2/input-day-two.txt").readLines()
    var totalScore = 0
    val strategies  = input.map { 
            it.split("\\s+".toRegex()).let { move ->
                Pair(move[0], move[1])
            }
        }

    strategies.forEach {
        totalScore += outComeScore.getValue(it.second) 
        totalScore += calculateShapeToWin(it)
    }

    println(totalScore)
}

fun calculateShapeToWin(strategy: Pair<String, String>): Int {
    val win = mapOf(
        Pair("A", "B"),
        Pair("B", "C"),
        Pair("C", "A"),
    )
    val lose = mapOf(
        Pair("A", "C"),
        Pair("B", "A"),
        Pair("C", "B"),
    )
    val shapeScore = mapOf(
        Pair("A", 1),
        Pair("B", 2),
        Pair("C", 3),
    )


    var shape = strategy.first

    if (strategy.second == "X") 
        shape = lose.getValue(strategy.first)
    if (strategy.second == "Z")
        shape = win.getValue(strategy.first)

    return shapeScore.getValue(shape)
}