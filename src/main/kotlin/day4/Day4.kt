package day4

import java.io.*

fun main() {
    partA()
    partB()
}

fun partA() {
    val inputs = File("./src/main/kotlin/day4/input.txt").readLines()
    var count = 0
    inputs.forEach { input ->
        val assignedSections = input.split(",").map { sections ->
            sections.split("-").let {
                Pair(it.first().toInt(), it.last().toInt())
            }
        }

        val pair1 = assignedSections.first()
        val pair2 = assignedSections.last()

        if ((pair1.first <= pair2.first && pair1.second >= pair2.second) ||
            (pair2.first <= pair1.first && pair2.second >= pair1.second)) {
            println("$pair1 $pair2")
            count++

        }
    }

    println(count)
}


fun partB() {
    val inputs = File("./src/main/kotlin/day4/input.txt").readLines()
    var count = 0
    inputs.forEach { input ->
        val assignedSections = input.split(",").map { sections ->
            sections.split("-").let {
                Pair(it.first().toInt(), it.last().toInt())
            }
        }

        val pair1 = assignedSections.first()
        val pair2 = assignedSections.last()


        if ((pair1.first <= pair2.first && pair1.second >= pair2.first) ||
            (pair2.first <= pair1.first && pair2.second >= pair1.first)
            ) {
            println("$pair1 $pair2")
            count++

        }
    }

    println(count)
}