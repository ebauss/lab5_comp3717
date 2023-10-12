package com.example.lab5evonbausa
import kotlin.random.Random

class Hunt(minion: Minion) : Mission(minion), Repeatable {
    override fun determineMissionTime(): Int {
        return minion.baseHealth * minion.baseSpeed * Random.nextInt(5)
    }

    override fun reward(int: Int): String {
        return when (determineMissionTime()) {
            in 11..20 -> "mouse"
            in 21..30 -> "fox"
            in 31..50 -> "buffalo"
            else -> "nothing"
        }
    }

    override fun repeat(int: Int, listener: MissionListener) {
        repeat(int) {
            start(listener)
        }
    }
}