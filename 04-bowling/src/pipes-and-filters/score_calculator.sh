#!/bin/bash

# Read rolls from stdin and calculate the score
read -r input
rolls=($input)

num_rolls=${#rolls[@]}

# Score calculation logic
score=0
frame=1
roll_index=0

while (( frame <= 10 && roll_index < ${#rolls[@]} )); do
    if (( rolls[roll_index] == 10 )); then  # Strike
        score=$(( score + 10 + rolls[roll_index + 1] + rolls[roll_index + 2] ))
        (( roll_index++ ))
    elif (( rolls[roll_index] + rolls[roll_index + 1] == 10 )); then  # Spare
        score=$(( score + 10 + rolls[roll_index + 2] ))
        (( roll_index += 2 ))
    else
        score=$(( score + rolls[roll_index] + rolls[roll_index + 1] ))
        (( roll_index += 2 ))
    fi

    (( frame++ ))
done

echo "Game Score: $score"
