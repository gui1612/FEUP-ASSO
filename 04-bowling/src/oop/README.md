# Bowling Calculator - Object Oriented

## Index

1. [Introduction](#introduction)
2. [Rules](#rules)
3. [How to Run](#how-to-compile-and-run)
   - [Using Intellij](#using-intellij)

## Introduction

This program calculates the score of a bowling game based on the rolls provided in an input file.

## Rules

To run this you must give a valid input file.

An input file represents a score entry of a single bowling game. A number in this file represents the number of pins hit by a player in a single round.

**Plays with 0 pins hit** should also be saved in the input file with "0" (the number of pins hit).

**"Skipped Plays"** such as the second round of a frame after a Strike, should not even be mentioned in the input file, since no play has occurred.

## How to Run

### Using Intellij

To run the program you should follow these steps:

1. Install the Kotlin plugin in Intellij 
2. Import the Gradle project in Intellij
3. Go to "more actions" > "edit" on the right of the Run/Debug icon
4. Set the input file on "Program arguments" (e.g. `input/b5sp.txt`)
5. Run the program 