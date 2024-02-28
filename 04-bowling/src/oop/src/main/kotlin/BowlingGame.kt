package org.example

open class BowlingGame(val frames: List<Frame>) {
    companion object {
        const val FRAMES_PER_GAME = 10;
        const val MAX_ROLLS_PER_GAME = 21;
    }

    init {
        if (frames.size > FRAMES_PER_GAME)
            throw Error("The maximum number of frames is %d".format(FRAMES_PER_GAME))

        val totalRolls = frames.sumOf { frame -> frame.rolls.size }

        if (totalRolls > MAX_ROLLS_PER_GAME)
            throw Error("The maximum number of frames is %d".format(MAX_ROLLS_PER_GAME))
    }

    fun calculateScore() : Int {
        var score = 0;
        var frameIndex = 0;

        for (frame in frames) {
            score += frame.getScore()

            if (frame.isStrike() && frameIndex < frames.size - 1) {
                score += nextTwoRolls(frameIndex)
            } else if (frame.isSpare() && frameIndex < frames.size - 1) {
                score += nextRoll(frameIndex)
            }

            frameIndex++
        }

        return score;
    }


    private fun nextTwoRolls(frameIndex: Int): Int {
        val nextFrame = frames[frameIndex + 1]

        if (nextFrame.isStrike() && frameIndex < frames.size - 2) {
            return nextFrame.getScore() + frames[frameIndex + 2].rolls[0];
        } else if (nextFrame.isStrike()){       // 9th frame edge case
            return nextFrame.rolls[0] + nextFrame.rolls[1];
        } else {
            return nextFrame.getScore();
        }
    }

    private fun nextRoll(frameIndex: Int): Int {
        val nextFrame = frames[frameIndex + 1]
        return nextFrame.rolls[0]
    }
}

