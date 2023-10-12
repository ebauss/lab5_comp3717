package com.example.lab5evonbausa

interface Repeatable {
    var repeatNum: Int
    fun repeat(int: Int, listener: MissionListener)
}