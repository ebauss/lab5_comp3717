package com.example.lab5evonbausa
import kotlin.properties.Delegates
import kotlin.random.Random

class Hunt(minion: Minion,  item: Item? = null) : Mission(minion, item), Repeatable {
    override fun determineMissionTime(): Int {
        return (minion.baseHealth + minion.baseSpeed + (item?.timeModifier ?: 0)) * Random.nextInt(5)
    }

    override fun reward(int: Int): String {
        if (minion.race == "elf") {
             return (minion as Elf).huntReward(determineMissionTime())
        }

        return when (determineMissionTime()) {
            in 11..20 -> "mouse"
            in 21..30 -> "fox"
            in 31..40 -> "buffalo"
            in 41..60 -> "dinosaur"
            else -> "nothing"
        }
    }

    override var repeatNum: Int by Delegates.vetoable(3) {
            _, _, newValue ->
        newValue <= 3
    }

    override fun repeat(int: Int, listener: MissionListener) {
        if (int > 3) {
            println("A minion cannot repeat a hunt more than 3 times! Repeating a hunt 3 times...\n")
        } else {
            println("Repeating a hunt $int times...\n")
        }
        repeat(int) {
            start(listener)
        }
    }
}