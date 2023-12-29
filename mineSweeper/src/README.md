
# MineSweeper Game

This is a simple implementation of the classic Minesweeper game in Java. The MineSweeper class provides functionality to create a Minesweeper game board, add mines randomly, and allow the player to uncover cells while avoiding mines.

## How to Use

1. **Initialize the Game**
    - Create an instance of the `MineSweeper` class.
    - Call the `start()` method to begin the game.
    - Enter the desired size for the game board (minimum size: 2x2).

2. **Gameplay**
    - The game will prompt you to input row and column numbers to select a cell.
    - Uncover cells by entering the row and column numbers.
    - The goal is to uncover all cells without revealing any mines.

3. **Game Controls**
    - Rows and columns are zero-indexed.
    - Avoid uncovering cells containing mines (`| * |`) to win the game.
    - The game ends if a mine is uncovered.

4. **Legend**
    - `| - |`: Represents an unrevealed cell.
    - `| * |`: Represents a cell containing a mine.
    - `| a |`: Represents the number of mines adjacent to a cell.

## Class Structure

- `MineSweeper`: Main class handling game logic.
- `start()`: Initializes the game by setting the game board size and starts the game loop.
- `run()`: Runs the main game loop where players interact with the game board.
- `check(int r, int c)`: Checks the selected cell for adjacent mines and updates the game board accordingly.
- `addMines()`: Randomly adds mines to the game board.
- `printMap(String[][] arr)`: Prints the game board.

Feel free to explore the code and customize it further to enhance the game experience.



