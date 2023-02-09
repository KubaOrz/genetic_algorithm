package sudoku;

import GeneticAlgorithmFramework.Individual;
import GeneticAlgorithmFramework.Mutation;

import java.util.Random;
import java.util.Set;

public class SudokuBoardMutation implements Mutation {

    private static Random random;
    private final double mutationFrequency;

    public SudokuBoardMutation() {
        random = new Random();
        this.mutationFrequency = 1;
    }

    @Override
    public Individual[] mutate(Individual[] population) {
        for (Individual boardIndividual: population) {
            if (random.nextDouble() < mutationFrequency) {
                SudokuBoard mutableBoardIndividual = (SudokuBoard) boardIndividual;
                Integer[][] mutableBoard = mutableBoardIndividual.getBoard();
                int cellsToMut = random.nextInt(10,30);
                while (cellsToMut > 0) {
                    int x = random.nextInt(9);
                    int y = random.nextInt(9);
                    if (mutableBoard[x][y] != null) {
                        Set<Integer> possibleInputs = SudokuInputValidator.checkPossibleInputs(mutableBoard, x, y);
                        if (possibleInputs.size() > 0) {
                            int newValue = random.nextInt(possibleInputs.size());
                            mutableBoard[x][y] = newValue;
                            mutableBoardIndividual.setBoard(mutableBoard);
                            cellsToMut--;
                        }
                    }
                }
            }
        }
        return population;
    }
}
