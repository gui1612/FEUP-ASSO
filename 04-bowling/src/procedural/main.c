#include <stdio.h>
#include <stdlib.h>

#define MAX_ROLLS 21  // Maximum number of rolls in a game
#define MAX_FRAMES 10 // Maximum number of frames in a game

/**
 * @brief Calculates the score of a bowling game
 * 
 * @param rolls Array of rolls in the game
 * @param num_rolls  Total number of rolls in the game
 * @return int Final score of the game
 */
int calculate_score(int *rolls, int num_rolls) {
    int score = 0;
    int roll_index = 0;


    for (int frame = 0; roll_index < num_rolls && frame < MAX_FRAMES; frame++) {
        if (rolls[roll_index] == 10) {                                      // Strike
            score += 10 + rolls[roll_index + 1] + rolls[roll_index + 2];
            roll_index++;
        } else if (rolls[roll_index] + rolls[roll_index + 1] == 10) {       // Spare
            score += 10 + rolls[roll_index + 2];
            roll_index += 2;
        } else {            
            score += rolls[roll_index] + rolls[roll_index + 1];
            roll_index += 2;
        }
    }   

    return score;
}


/**
 * @brief Reads the game information from a file. The memory region pointed at by the return value of this function must be manually freed by client code.
 * 
 * @param filename Name of the file containing the game information
 * @param num_rolls Number of rolls in the game
 * 
 * @return int* Array of rolls in the game
 */
int* read_game(char *filename, int *num_rolls) {
    FILE *file = fopen(filename, "r");

    if (file == NULL) {
        printf("Error: Unable to open file %s\n", filename);
        return NULL;
    }

    int *rolls = (int *)malloc(MAX_ROLLS * sizeof(int));

    if (rolls == NULL) {
        printf("Error: Unable to allocate memory for rolls\n");
        return NULL;
    }

    int roll_index = 0;

    while (fscanf(file, "%d", &rolls[roll_index]) != EOF)
        roll_index++;

    *num_rolls = roll_index;

    // Closing the file
    fclose(file);

    return rolls;

}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        printf("Usage: %s <input_file>\n", argv[0]);
        return EXIT_FAILURE;
    }

    char *filename = argv[1];

    int num_rolls;

    int *rolls = read_game(filename, &num_rolls);

    // Checking if the file was read successfully
    if (rolls == NULL)
        return EXIT_FAILURE;

    int score = calculate_score(rolls, num_rolls);

    printf("Game Score: %d\n", score);

    free(rolls);

    return EXIT_SUCCESS;
}