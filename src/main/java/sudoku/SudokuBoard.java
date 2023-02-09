package sudoku;

import GeneticAlgorithmFramework.Individual;

public class SudokuBoard implements Individual {

    private Integer[][] board;
    private int fitness;

    public SudokuBoard(Integer[][] board) {
        this.board = board;
        SudokuBoardCalculator calculator = SudokuBoardCalculator.getInstance();
        this.fitness = (int) calculator.calculateValue(this);
    }

    @Override
    public int getFitness() {
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
}
