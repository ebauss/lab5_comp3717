package com.example.lab5evonbausa

interface MissionListener {
    fun missionStart(minion: Minion, string: String): Unit
    fun missionProgress()
    fun missionComplete(minion: Minion, string: String)
}