package sudoku;

import GeneticAlgorithmFramework.Crossover;
import GeneticAlgorithmFramework.Individual;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SudokuBoardCrossover implements Crossover {

    private static Random random;

    public SudokuBoardCrossover() {
        if (random == null) {
            random = new Random();
        }
    }

    @Override
    public Individual[] cross(Individual[] parents) {
        int childrenCount = parents.length;
        SudokuBoard[] parentSudokuBoards = new SudokuBoard[childrenCount];
        SudokuBoard[] children = new SudokuBoard[childrenCount];

        for (int i = 0; i < childrenCount; i++) {
            parentSudokuBoards[i] = (SudokuBoard) parents[i];
        }

        for (int i = 0; i < childrenCount; i++) {
            Integer[][] childBoard = SudokuBoardGenerator.copyPuzzleSample();
            Set<Integer> unchecked = new HashSet<>();
            for (int j = 0; j < 81; j++) {
                unchecked.add(j);
            }
            for (int j = 0; j < 81; j++) {
                int cell = random.nextInt(0, unchecked.size());
                int parent = random.nextInt(0, childrenCount);
                int x = cell / 9;
                int y = cell % 9;
                Set<Integer> possibleInputs = SudokuInputValidator.checkPossibleInputs(childBoard, x, y);
                if (possibleInputs.contains(parentSudokuBoards[parent].getValueFromBoard(x, y))) {
                    childBoard[x][y] = parentSudokuBoards[parent].getValueFromBoard(x, y);
                } else {
                    // TODO jeśli nie dopasujemy to może lepiej tam coś wsadzić z innego rodzica
                }
                unchecked.remove(cell);
            }
            children[i] = new SudokuBoard(childBoard);
        }
        return children;
    }
}
