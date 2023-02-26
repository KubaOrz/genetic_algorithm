package sudoku;

import geneticAlgorithmFramework.configuration.GlobalSettings;
import geneticAlgorithmFramework.Individual;
import geneticAlgorithmFramework.ObjectiveFunction;

public class SudokuBoard implements Individual {

    private Integer[][] board;
    private double fitness;
    private final ObjectiveFunction calculator;

    public SudokuBoard(Integer[][] board) {
        this.board = board;
        calculator = GlobalSettings.getInstance().getObjectiveFunction();
        this.fitness = calculator.calculateValue(this);
    }

    @Override
    public double getFitness() {
        return fitness;
    }

    public Integer[][] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("_________________\n");
        builder.append(fitness).append("\n\n");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != null) {
                    builder.append(board[i][j]).append(" ");
                } else {
                    builder.append("- ");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public Integer getValueFromBoard(int x, int y) {
        return board[x][y];
    }

    @Override
    public int compareTo(Individual o) {
        return Double.compare(fitness, o.getFitness());
    }
}
