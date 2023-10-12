package com.example.lab5evonbausa

abstract class Mission(
    protected val minion: Minion,
    protected val item: Item? = null
) {

    fun start(listener: MissionListener) {
        val stringStart = when (this) {
            is Gather -> "was sent off to gather some resources!"
            else -> "started a new hunt!"
        }
        listener.missionStart(minion, stringStart)
        listener.missionProgress()

        val reward = reward(determineMissionTime())

        val stringComplete = when (this) {
            is Gather -> "gathering, and found $reward"
            else -> {
                if (reward == "nothing") {
                    "a hunt and found nothing"
                } else {
                    "a hunt, and found a $reward"
                }
            }
        }
        listener.missionComplete(minion, stringComplete)
    }

    protected abstract fun determineMissionTime(): Int
    protected abstract fun reward(int: Int): String
}