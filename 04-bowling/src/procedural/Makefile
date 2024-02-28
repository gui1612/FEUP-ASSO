CC = gcc
CFLAGS = -Wall -Wextra -Werror
TARGET = main
INPUT_DIR = input
INPUT_FILE = b7x.txt

all: $(TARGET)

$(TARGET): $(TARGET).c
	$(CC) $(CFLAGS) -o $@ $<

run: $(TARGET) $(INPUT_DIR)/$(INPUT_FILE)
	./$(TARGET) $(INPUT_DIR)/$(INPUT_FILE)

benchmark: $(TARGET) $(INPUT_DIR)/$(INPUT_FILE)
	time ./$(TARGET) $(INPUT_DIR)/$(INPUT_FILE)

clean:
	rm -f $(TARGET)