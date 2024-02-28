# Bowling Calculator - Pipes and Filters

## Index

1. [Introduction](#introduction)
2. [Rules](#rules)
3. [How to Run](#how-to-compile-and-run)

## Introduction

This program calculates the score of a bowling game based on the rolls provided in an input file.

## Rules

To run this you must give a valid input file.

An input file represents a score entry of a single bowling game. A number in this file represents the number of pins hit by a player in a single round.

**Plays with 0 pins hit** should also be saved in the input file with "0" (the number of pins hit).

**"Skipped Plays"** such as the second round of a frame after a Strike, should not even be mentioned in the input file, since no play has occurred.

## How to Run

You need to run two scripts in order to get the score of the game. The first one is `roll_parser.sh` and the second one, which accepts the input of the previous one is `score_calculator.sh`.

You need to run it as follows:

```bash
./roll_parser.sh <input_file> | ./score_calculator.sh
```

Note: You can run either one of them standalone, if you find any use to do so.

## FAQ

#### Why do I get a "Permission Denied" message
You need to give permissions to both of the scripts. You can do so with the following command:

```bash
chmod +x <scrip_name>
```