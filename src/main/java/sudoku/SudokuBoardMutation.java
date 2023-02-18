package sudoku;

import GeneticAlgorithmFramework.Configuration.GlobalSettings;
import GeneticAlgorithmFramework.Individual;
import GeneticAlgorithmFramework.GeneticOperators.Mutation;

import java.util.List;
import java.util.Random;

public class SudokuBoardMutation implements Mutation {

    private final Random random;
    private final GlobalSettings settings;
    public SudokuBoardMutation() {
        this.random = new Random();
        this.settings = GlobalSettings.getInstance();
    }

    @Override
    public Individual[] mutate(Individual[] population) {
        for (int i = 0; i < population.length; i++) {
            if (random.nextDouble() < settings.getMutationFrequency()) {
                SudokuBoard mutableBoardIndividual = (SudokuBoard) population[i];
                Integer[][] mutableBoard = mutableBoardIndividual.getBoard();
                int cellsToMut = random.nextInt(5, 15);
                while (cellsToMut > 0) {
                    int x = random.nextInt(9);
                    int y = random.nextInt(9);
                    List<Integer> possibleInputs = SudokuInputValidator.checkPossibleInputs(mutableBoard, x, y);
                    if (possibleInputs.size() > 0) {
                        int newValue = possibleInputs.get(random.nextInt(possibleInputs.size()));
                        mutableBoard[x][y] = newValue;
                        mutableBoardIndividual.setBoard(mutableBoard);
                        population[i] = mutableBoardIndividual;
                        cellsToMut--;
                    }
                }
            }
        }
        return population;
    }
}
