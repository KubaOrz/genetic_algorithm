package sudoku;

import GeneticAlgorithmFramework.Configuration.GlobalSettings;
import GeneticAlgorithmFramework.Individual;
import GeneticAlgorithmFramework.ObjectiveFunction;

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

    @Override
    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public Integer[][] getBoard() {
        return board;
    }

    public void setBoard(Integer[][] newBoard) {
        this.board = newBoard;
        this.fitness = (int) calculator.calculateValue(this);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("______________________________\n");
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
