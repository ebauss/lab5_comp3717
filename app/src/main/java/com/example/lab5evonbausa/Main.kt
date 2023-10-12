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
    val elfGather = Gather(elf)
    val elfHunt = Hunt(elf)
    val orcGather = Gather(orc, Item.COMPASS)
    val orcHunt = Hunt(orc, Item.MAP)

    humanGather.repeat(1, missionListener)
    humanHunt.repeat(1, missionListener)
    dwarfGather.repeat(1, missionListener)
    dwarfHunt.repeat(1, missionListener)
    elfGather.repeat(1, missionListener)
    elfHunt.repeat(2, missionListener)
    orcGather.repeat(3, missionListener)
    orcHunt.repeat(4, missionListener)
}