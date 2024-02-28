# Bowling Calculator - Procedural

## Index

1. [Introduction](#introduction)
2. [Rules](#rules)
3. [How to Compile and Run](#how-to-compile-and-run)
   - [Manual Compilation](#manual-compilation)
   - [Using Make](#using-make)
4. [Cleaning Up](#cleaning-up)
5. [Note](#note)

## Introduction

This program calculates the score of a bowling game based on the rolls provided in an input file.

## Rules

To run this you must give a valid input file.

An input file represents a score entry of a single bowling game. A number in this file represents the number of pins hit by a player in a single round.

**Plays with 0 pins hit** should also be saved in the input file with "0" (the number of pins hit).

**"Skipped Plays"** such as the second round of a frame after a Strike, should not even be mentioned in the input file, since no play has occurred.

## How to Compile and Run

### Manual Compilation

To compile the program manually, follow these steps:

1. Open a terminal.
2. Navigate to the directory containing the source code.
3. Compile the program using the following command:

```bash
gcc -o main main.c
```

4. After successful compilation, you can run the program using the following command:


```bash
./main <input_file>
```

### Using Make

To compile the program using the provided Makefile, follow these steps:


1. Open a terminal.
2. Navigate to the directory containing the source code.
3. Run the program simply by using the `make run` command

Note: This will use the `INPUT_DIR/INPUT_FILE` present in the [Makefile](./Makefile). Feel free to change those variables and the rest of the file.

4. [OPTIONAL]: To clean up the compiled files, you can use `make clean`