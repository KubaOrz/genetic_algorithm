package sudoku;

import java.util.*;

public class SudokuInputValidator { // TODO zmienić te sety na normalne listy

    public static Set<Integer> checkPossibleInputs(Integer[][] puzzle, int column, int row) {
        Set<Integer> inputs;
        inputs = checkColumn(puzzle, column);
        inputs.addAll(checkRow(puzzle, row));
        inputs.addAll(checkSquare(puzzle, column, row));
        Set<Integer> possibleInputs = new HashSet<>();

        for (int i = 1; i <= 9; i++) {
            if (!inputs.contains(i)) {
                possibleInputs.add(i);
            }
        }
        return possibleInputs;
    }

    private static Set<Integer> checkColumn(Integer[][] puzzle, int column) {
        Set<Integer> numbersInColumn = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            numbersInColumn.add(puzzle[column][i]);
        }
        return numbersInColumn;
    }

    private static Set<Integer> checkRow(Integer[][] puzzle, int row) {
        Set<Integer> numbersInRow = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            numbersInRow.add(puzzle[i][row]);
        }
        return numbersInRow;
    }

    private static Set<Integer> checkSquare(Integer[][] puzzle, int column, int row) {
        Set<Integer> numbersInSquare = new HashSet<>();
        int horizontal = column / 3;
        int vertical = row / 3;
        for (int i = 3 * horizontal; i < 3 * (horizontal + 1); i++) {
            for (int j = 3 * vertical; j < 3 * (vertical  + 1); j++) {
                numbersInSquare.add(puzzle[i][j]);
            }
        }
        return numbersInSquare;
    }
}
