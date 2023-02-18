package sudoku;

import java.util.*;

public class SudokuInputValidator {

    public static List<Integer> checkPossibleInputs(Integer[][] puzzle, int row, int column) {
        List<Integer> inputs;
        inputs = checkColumn(puzzle, column);
        inputs.addAll(checkRow(puzzle, row));
        inputs.addAll(checkSquare(puzzle, column, row));
        List<Integer> possibleInputs = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            if (!inputs.contains(i)) {
                possibleInputs.add(i);
            }
        }
        return possibleInputs;
    }

    private static List<Integer> checkColumn(Integer[][] puzzle, int column) {
        List<Integer> numbersInColumn = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            numbersInColumn.add(puzzle[i][column]);
        }
        return numbersInColumn;
    }

    private static List<Integer> checkRow(Integer[][] puzzle, int row) {
        List<Integer> numbersInRow = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            numbersInRow.add(puzzle[row][i]);
        }
        return numbersInRow;
    }

    private static List<Integer> checkSquare(Integer[][] puzzle, int row, int column) {
        List<Integer> numbersInSquare = new ArrayList<>();
        int horizontal = column / 3;
        int vertical = row / 3;
        for (int i = 3 * vertical; i < 3 * (vertical + 1); i++) {
            for (int j = 3 * horizontal; j < 3 * (horizontal  + 1); j++) {
                numbersInSquare.add(puzzle[i][j]);
            }
        }
        return numbersInSquare;
    }
}
