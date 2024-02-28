package org.example

class FileBasedBowlingGame(parser: Parser, filename: String) : BowlingGame(populateFrames(parser.parseRollsFromFile(filename))) {

    companion object {
        private fun populateFrames(rolls: IntArray): List<Frame> {
            val frames = mutableListOf<Frame>()
            var index = 0

            repeat(FRAMES_PER_GAME) {

                val strike = rolls[index] == 10;
                var frameRolls = intArrayOf(rolls[index]);

                if (it == FRAMES_PER_GAME - 1) { // last frame
                    frameRolls += rolls[index + 1];
                    if (strike || frameRolls.sum() == 10)   // Strike or spare
                        frameRolls += rolls[index + 2];

                } else {                        // other frames
                    if (!strike)
                        frameRolls += rolls[index + 1]
                }

                frames.add(Frame(frameRolls))
                index += if (strike) 1 else 2
            }

            return frames
        }
    }

}