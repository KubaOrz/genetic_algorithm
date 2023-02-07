package sudoku;

import GeneticAlgorithmFramework.Individual;
import GeneticAlgorithmFramework.PopulationGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SudokuBoardGenerator implements PopulationGenerator {

    private final Integer[][] puzzleSample;
    private final SampleSolutionGenerator solutionGenerator;

    public SudokuBoardGenerator(String path) {
        this.puzzleSample = new Integer[9][9];
        this.solutionGenerator = new SampleSolutionGenerator();
        readPuzzleFromTxt(path);
    }

    public SudokuBoardGenerator() {
        this.solutionGenerator = new SampleSolutionGenerator();
        this.puzzleSample = solutionGenerator.generateSamplePuzzle();
    }

    @Override
    public Individual[] generatePopulation(int number) {
        Individual[] initialPopulation = new Individual[number];
        for (int i = 0; i < number; i++) {
            Integer[][] newBoard = puzzleSample.clone();
            newBoard = solutionGenerator.generateSampleSolution(newBoard);
            Individual sudokuBoard = new SudokuBoard(newBoard);
            initialPopulation[i] = sudokuBoard;
        }
        return initialPopulation;
    }

    @Override
    public Individual generateIndividual() {
        Integer[][] newBoard = puzzleSample.clone();
        newBoard = solutionGenerator.generateSampleSolution(newBoard);
        return new SudokuBoard(newBoard);
    }

    private void readPuzzleFromTxt(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while (reader.ready()) {
                char[] line = reader.readLine().toCharArray();
                int x = Integer.parseInt(String.valueOf(line[0]));
                int y = Integer.parseInt(String.valueOf(line[1]));
                int value = Integer.parseInt(String.valueOf(line[2]));
                puzzleSample[x][y] = value;
            }
        } catch (IOException e) {
            //TODO może jakiś logger czy coś
        }
    }
}
