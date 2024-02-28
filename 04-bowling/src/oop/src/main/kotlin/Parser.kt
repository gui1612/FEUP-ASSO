package org.example

import java.io.File

class Parser() {
    fun parseRollsFromFile(filename: String): IntArray {
        val rolls = mutableListOf<Int>();

        File(filename).forEachLine { line ->
            line.trim().split(Regex("\\s+")).forEach { roll ->
                if (roll.isNotEmpty())      // Empty lines
                    rolls.add(roll.toInt());
            }
        }

        return rolls.toIntArray();
    }
}