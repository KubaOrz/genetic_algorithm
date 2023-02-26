package sudoku;

import geneticAlgorithmFramework.Individual;
import geneticAlgorithmFramework.ObjectiveFunction;

public class SudokuBoardCalculator implements ObjectiveFunction {

    @Override
    public double calculateValue(Individual x) {
        if (!(x instanceof SudokuBoard sudokuBoard)) {
            throw new IllegalArgumentException();
        }

        int fitness = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudokuBoard.getBoard()[i][j] == null) {
                    fitness++;
                }
            }
        }
        return fitness;
    }
}
