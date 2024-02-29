#!/bin/bash

filename=$1

# Extract numbers using grep and output as space-separated integers
grep -oE '[0-9]+' "$filename" | tr '\n' ' '
