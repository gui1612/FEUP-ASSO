package org.example

class Frame(val rolls: IntArray) {
    fun isStrike() : Boolean {
        return rolls[0] == 10;
    }
    
    fun isSpare() : Boolean {
        return rolls.size == 2 && rolls.sum() == 10;
    }

    fun getScore() : Int {
        return rolls.sum();
    }
}