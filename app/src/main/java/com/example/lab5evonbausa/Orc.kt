package com.example.lab5evonbausa

class Orc(private val minion: Minion): Minion by minion {
    override val race: String = "Orc"
    override val catchphrase: String = "ARRGH!"
}