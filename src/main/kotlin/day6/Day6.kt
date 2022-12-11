package day6

import java.io.File

fun main() {
    partAB(4)
    partAB(14)
}

fun partAB(numOfUnique: Int) {
    val input = File("./src/main/kotlin/day6/input.txt").readLines().first()
    val inputList = input.toList()

    for (i in inputList.indices) {
        if (i - numOfUnique >= 0) {
            val has4UniqueChars = inputList.subList(i - numOfUnique, i).toSet().size == numOfUnique
            if (has4UniqueChars) {
                println(i)
                break
            }
        }
    }


}
