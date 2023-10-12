package com.example.lab5evonbausa
import kotlin.random.Random

class Gather(minion: Minion) : Mission(minion), Repeatable {
    override fun determineMissionTime(): Int {
        return minion.backpackSize * minion.baseSpeed * Random.nextInt(5)
    }

    override fun reward(int: Int): String {
        return when (int) {
            in 10..21 -> "bronze"
            in 22..33 -> "silver"
            in 34..50 -> "gold"
            else -> "nothing"
        }
    }

    override fun repeat(int: Int, listener: MissionListener) {
        repeat(int) {
            start(listener)
        }
    }
}