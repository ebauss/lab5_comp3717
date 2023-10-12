package com.example.lab5evonbausa
import kotlin.properties.Delegates
import kotlin.random.Random

class Gather(minion: Minion, item: Item? = null) : Mission(minion, item), Repeatable {
    override fun determineMissionTime(): Int {
        return (minion.backpackSize + minion.baseSpeed + (item?.timeModifier ?: 0)) * Random.nextInt(5)
    }

    override fun reward(int: Int): String {
        return when (int) {
            in 10..21 -> "bronze"
            in 22..33 -> "silver"
            in 34..44 -> "gold"
            in 45..60 -> "diamond"
            else -> "nothing"
        }
    }

    override var repeatNum: Int by Delegates.vetoable(3) {
        _, _, newValue ->
        newValue <= 3
    }

    override fun repeat(int: Int, listener: MissionListener) {
        if (int > 3) {
            println("A minion cannot repeat a gather more than 3 times! Repeating a gather 3 times...\n")
        } else {
            println("Repeating a gather $int times...\n")
        }
        repeatNum = int
        repeat(repeatNum) {
            start(listener)
        }
    }
}