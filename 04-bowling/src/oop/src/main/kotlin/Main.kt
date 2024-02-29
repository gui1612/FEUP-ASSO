package org.example

fun main(args: Array<String>) {

    if (args.size != 1) {
        println("Usage: java -jar oop.jar <input_file>");
        return;
    }

    val filename = args[0];
    val parser = Parser();
    val game = FileBasedBowlingGame(parser, filename);

    val score = game.calculateScore();

    println("Game Score: $score");
}