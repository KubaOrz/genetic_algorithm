package sudoku;

import geneticAlgorithmFramework.Individual;
import geneticAlgorithmFramework.PopulationGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static sudoku.SudokuInputValidator.checkPossibleInputs;

public class SudokuBoardGenerator implements PopulationGenerator {

    private static Integer[][] puzzleSample;
    private final Random random = new Random();

    public SudokuBoardGenerator(String path) {
        puzzleSample = new Integer[9][9];
        readPuzzleFromTxt(path);
        System.out.println(new SudokuBoard(puzzleSample));

    }

    public SudokuBoardGenerator() {
        puzzleSample = generateSamplePuzzle();
        System.out.println(new SudokuBoard(puzzleSample));
    }

    @Override
    public Individual[] generatePopulation(int number) {
        Individual[] initialPopulation = new Individual[number];
        for (int i = 0; i < number; i++) {
            initialPopulation[i] = generateIndividual();
        }
        return initialPopulation;
    }

    @Override
    public Individual generateIndividual() {
        Integer[][] newBoard = generateSampleSolution(copyPuzzleSample());
        return new SudokuBoard(newBoard);
    }

    public static Integer[][] copyPuzzleSample() {
        return Arrays.stream(puzzleSample).map(Integer[]::clone).toArray(Integer[][]::new);
    }

    private void readPuzzleFromTxt(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while (reader.ready()) {
                char[] line = reader.readLine().replace(" ", "").toCharArray();
                int x = Integer.parseInt(String.valueOf(line[0]));
                int y = Integer.parseInt(String.valueOf(line[1]));
                int value = Integer.parseInt(String.valueOf(line[2]));
                puzzleSample[y][x] = value;
            }
        } catch (IOException e) {
            System.out.println("Can't find the given file! Generating random puzzle...");
            puzzleSample = generateSamplePuzzle();
        }
    }

    private Integer[][] generateSampleSolution(Integer[][] puzzle) {
        List<Integer> unchecked = new ArrayList<>();
        for (int i = 0; i < 81; i++) {
            unchecked.add(i);
        }
        for (int i = 0; i < 81; i++) {
            int cell = random.nextInt(0, unchecked.size());
            int x = cell / 9;
            int y = cell % 9;
            if (puzzle[x][y] == null) {
                puzzle[x][y] = findMatchingInput(puzzle, x, y);
                unchecked.remove(cell);
            }
        }
        return puzzle;
    }

    private Integer[][] generateSamplePuzzle() {
        Integer[][] puzzle = new Integer[9][9];
        int filledCells = 0;
        while (filledCells < 30) {
            int x = random.nextInt(0, 9);
            int y = random.nextInt(0, 9);
            if (puzzle[x][y] == null) {
                puzzle[x][y] = findMatchingInput(puzzle, x, y);
                filledCells++;
            }
        }
        return puzzle;
    }

    private Integer findMatchingInput(Integer[][] puzzle, int column, int row) {
        List<Integer> possibleInputs = checkPossibleInputs(puzzle, column, row);
        if (possibleInputs.size() == 0) {
            return null;
        }
        return possibleInputs.get(random.nextInt(possibleInputs.size()));
    }
}
