package sudoku;

import GeneticAlgorithmFramework.GeneticOperators.Crossover;
import GeneticAlgorithmFramework.Configuration.GlobalSettings;
import GeneticAlgorithmFramework.Individual;

import java.util.*;

public class SudokuBoardCrossover implements Crossover {

    private final Random random;
    private final GlobalSettings settings;
    private final int boardSize;

    public SudokuBoardCrossover() {
        this.random = new Random();
        this.settings = GlobalSettings.getInstance();
        this.boardSize = 9;
    }

    @Override
    public Individual[] cross(Individual[] parents) {
        int childrenCount = settings.getNumberOfChildren();
        SudokuBoard[] parentSudokuBoards = new SudokuBoard[GlobalSettings.NUMBER_OF_PARENTS];
        Individual[] children = new Individual[childrenCount];

        for (int i = 0; i < GlobalSettings.NUMBER_OF_PARENTS; i++) {
            parentSudokuBoards[i] = (SudokuBoard) parents[i];
        }

        for (int i = 0; i < childrenCount; i++) {
            Integer[][] childBoard = SudokuBoardGenerator.copyPuzzleSample();
            List<Integer> unchecked = findUnchecked(childBoard);

            while (unchecked.size() > 0) {
                Integer cell = unchecked.get(random.nextInt(unchecked.size()));
                int parent = random.nextInt(GlobalSettings.NUMBER_OF_PARENTS);
                int x = cell / boardSize;
                int y = cell % boardSize;
                List<Integer> possibleInputs = SudokuInputValidator.checkPossibleInputs(childBoard, x, y);

                if (possibleInputs.isEmpty()) {
                    unchecked.remove(cell);
                    continue;
                }

                if (random.nextDouble() < settings.getMutationFrequency()) {
                    childBoard[x][y] = possibleInputs.get(random.nextInt(possibleInputs.size()));
                } else if (possibleInputs.contains(parentSudokuBoards[parent].getValueFromBoard(x, y))) {
                    childBoard[x][y] = parentSudokuBoards[parent].getValueFromBoard(x, y);
                }
                unchecked.remove(cell);
            }

            unchecked = findUnchecked(childBoard);
            while (unchecked.size() > 0) {
                Integer cell = unchecked.get(random.nextInt(unchecked.size()));
                int x = cell / boardSize;
                int y = cell % boardSize;
                List<Integer> possibleInputs = SudokuInputValidator.checkPossibleInputs(childBoard, x, y);

                if (possibleInputs.isEmpty()) {
                    unchecked.remove(cell);
                    continue;
                }
                childBoard[x][y] = possibleInputs.get(random.nextInt(possibleInputs.size()));
                unchecked.remove(cell);
            }
            children[i] = new SudokuBoard(childBoard);
        }
        return children;
    }

    private List<Integer> findUnchecked(Integer[][] puzzleSample) {
        List<Integer> unchecked = new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (puzzleSample[i][j] == null) {
                    unchecked.add(i * boardSize + j);
                }
            }
        }
        return unchecked;
    }
}
