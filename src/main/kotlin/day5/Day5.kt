package day5

import java.io.File

fun main() {
    partA()
    partB()
}

class Day5 {
    companion object {
        val crates = listOf(
            mutableListOf('T','V','J','W','N','R','M','S'),
            mutableListOf('V','C','P','Q','J','D','W','B'),
            mutableListOf('P','R','D','H','F','J','B'),
            mutableListOf('D','N','M','B','P','R','F'),
            mutableListOf('B','T','P','R','V','H'),
            mutableListOf('T','P','B','C'),
            mutableListOf('L','P','R','J','B'),
            mutableListOf('W','B','Z','T','L','S','C','N',),
            mutableListOf('G', 'S', 'L'),
        )
    }
}

fun partA() {
    val inputs = File("./src/main/kotlin/day5/input.txt").readLines()
    val crates = Day5.crates.toMutableList()
    inputs.forEach { input ->
        val instruction = input.removePrefix("move ").split("[a-z ]+".toRegex()).map { it.toInt() }
        val amountToMove = instruction[0]
        val from = instruction[1]
        val to = instruction[2]

        val fromCrate = crates[from-1]
        val toCrate = crates[to-1]

        for (i in 0 until amountToMove) {
            val item = fromCrate.removeFirst()
            toCrate.add(0, item)
        }
    }

    crates.forEach {
        print(it.first())
    }
}

fun partB() {
    val inputs = File("./src/main/kotlin/day5/input.txt").readLines()
    val crates = Day5.crates.toMutableList()
    inputs.forEach { input ->
        val instruction = input.removePrefix("move ").split("[a-z ]+".toRegex()).map { it.toInt() }
        val amountToMove = instruction[0]
        val from = instruction[1]
        val to = instruction[2]

        val fromCrate = crates[from-1]
        val toCrate = crates[to-1]

        for (i in 0 until amountToMove) {
            val item = fromCrate.removeFirst()
            toCrate.add(0 + i, item)
        }
    }

    crates.forEach {
        print(it.first())
    }
}
