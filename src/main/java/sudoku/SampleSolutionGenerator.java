package sudoku;

import java.util.*;

public class SampleSolutionGenerator {

    private Integer[][] puzzle;
    private final Random random;

    public SampleSolutionGenerator() {
        this.random = new Random();
    }

    public Integer[][] generateSampleSolution(Integer[][] puzzleSample) {
        this.puzzle = puzzleSample;
        List<Integer> unchecked = new ArrayList<>();
        for (int i = 0; i < 81; i++) {
            unchecked.add(i);
        }
        for (int i = 0; i < 81; i++) {
            int cell = random.nextInt(0, unchecked.size());
            int x = cell / 9;
            int y = cell % 9;
            puzzle[x][y] = findMatchingInput(x, y);
            unchecked.remove(cell);
        }
        return puzzleSample;
    }

    public Integer[][] generateSamplePuzzle() {
        this.puzzle = new Integer[9][9];
        int filledCells = 0;
        while (filledCells < 30) {
            int x = random.nextInt(0, 9);
            int y = random.nextInt(0, 9);
            if (puzzle[x][y] == null) {
                puzzle[x][y] = findMatchingInput(x, y);
                filledCells++;
            }
        }
        return puzzle;
    }

    private Integer findMatchingInput(int column, int row) {
        Set<Integer> possibleInputs = checkPossibleInputs(column, row);
        if (possibleInputs.size() == 0) {
            return null;
        }
        Integer[] possibleInputsArray = possibleInputs.toArray(new Integer[0]);
        return possibleInputsArray[random.nextInt(possibleInputs.size())];
    }

    private Set<Integer> checkPossibleInputs(int column, int row) {
        Set<Integer> inputs;
        inputs = checkColumn(column);
        inputs.addAll(checkRow(row));
        inputs.addAll(checkSquare(column, row));
        Set<Integer> possibleInputs = new HashSet<>();

        for (int i = 1; i <= 9; i++) {
            if (!inputs.contains(i)) {
                possibleInputs.add(i);
            }
        }
        return possibleInputs;
    }

    private Set<Integer> checkColumn(int column) {
        Set<Integer> numbersInColumn = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            numbersInColumn.add(puzzle[column][i]);
        }
        return numbersInColumn;
    }

    private Set<Integer> checkRow(int row) {
        Set<Integer> numbersInRow = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            numbersInRow.add(puzzle[i][row]);
        }
        return numbersInRow;
    }

    private Set<Integer> checkSquare(int column, int row) {
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
