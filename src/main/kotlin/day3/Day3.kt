package day3

import java.io.*

fun main() {
    partA()
    partB()
}

fun partA() {
    val inputs = File("./src/main/kotlin/day3/input.txt").readLines()
    var totalScore = 0

    inputs.forEach { input ->
        val mid = input.length / 2
        val compartment1 = input.substring(0, mid).toList()
        val compartment2 = input.substring(startIndex = mid).toList()

        val commonLetters = compartment1.intersect(compartment2)
        commonLetters.forEach { 
            val ascii = it.code
            if (ascii < 96)
                totalScore += (ascii - 64 + 26)
            else
                totalScore += (ascii - 96)
        }
    }
    println(totalScore)
}

fun calculateScore(letter: Char): Int {
    val ascii = letter.code
    if (ascii < 96)
        return (ascii - 64 + 26)
    else
        return (ascii - 96)
}

fun partB() {
    val inputs = File("./src/main/kotlin/day3/input.txt").readLines()
    var totalScore = 0

    val groups = inputs.chunked(3)

    groups.forEach {
        val first = it.first().toList()
        val second = it.get(1).toList()
        val third = it.last().toList()

        val commonLetters = first.intersect(second).intersect(third)

        commonLetters.forEach { totalScore += calculateScore(it.toChar()) }
    }
    println(totalScore)
}