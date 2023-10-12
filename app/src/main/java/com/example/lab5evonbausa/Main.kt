package com.example.lab5evonbausa

/*
    Evon Bausa
    A00888549
 */

fun main() {
    val missionListener = object : MissionListener {
        override fun missionStart(minion: Minion, string: String) {
            println("${minion.catchphrase}\n")
            if (minion.race == "Elf") {
                println("An Elf $string")
            } else {
                println("A ${minion.race} $string")
            }
        }

        override fun missionProgress() {
            println("...\n...\n...")
        }

        override fun missionComplete(minion: Minion, string: String) {
            if (minion.race == "Archer") {
                println("An Archer has returned from $string\n")
            } else {
                println("A ${minion.race} has return from $string\n")
            }
        }
    }

//    Instantiate the minions
    val human = Human()
    val dwarf = Dwarf()
    val elf = Elf()
    val orc = Orc(elf)

//    Instantiate the missions
    val humanGather = Gather(human)
    val humanHunt = Hunt(human)
    val dwarfGather = Gather(dwarf)
    val dwarfHunt = Hunt(dwarf)
    val archerGather = Gather(elf)
    val archerHunt = Hunt(elf)
    val orcGather = Gather(orc, Item.COMPASS)
    val orcHunt = Hunt(orc, Item.MAP)

    humanGather.repeat(2, missionListener)
    humanHunt.repeat(2, missionListener)
    dwarfGather.repeat(2, missionListener)
    dwarfHunt.repeat(2, missionListener)
    archerGather.repeat(2, missionListener)
    archerHunt.repeat(2, missionListener)
}