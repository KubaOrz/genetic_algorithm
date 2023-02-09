package sudoku;

import GeneticAlgorithmFramework.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SudokuGenerationTest {

    private static PopulationGenerator randomGenerator;
    private static PopulationGenerator txtGenerator;

    @BeforeAll
    static void setUp() {
        //randomGenerator = new SudokuBoardGenerator();
        txtGenerator = new SudokuBoardGenerator("src/test/resources/sudoku_test_cases/test_case_1");
    }

    @Test
    public void should_DisplayOneRandomSudokuBoard() {
        System.out.println(randomGenerator.generateIndividual());
    }

    @Test
    public void should_DisplayTestCase1SudokuBoard() {
        System.out.println(txtGenerator.generateIndividual());
    }

    @Test
    public void should_DisplayPopulationOfSudokuBoards() {
        // given
        int populationSize = 20;

        // when
        Individual[] population = randomGenerator.generatePopulation(populationSize);
        for (int i = 0; i < populationSize; i++) {
            System.out.println(population[i]);
        }
    }

    @Test
    public void should_CorrectlySelectParent_FromPopulation() {
        // given
        int populationSize = 10;
        Selection selection = new RouletteSelection();

        // when
        Individual[] population = randomGenerator.generatePopulation(populationSize);
        Individual[] parents = selection.select(population);
        for (Individual parent: parents) {
            System.out.println(parent);
        }
    }

    @Test
    public void should_CorrectlySelectAndCrossParent_FromPopulation() {
        // given
        int populationSize = 10;
        Selection selection = new RouletteSelection();
        Crossover crossover = new SudokuBoardCrossover();

        // when
        Individual[] population = randomGenerator.generatePopulation(populationSize);
        Individual[] parents = selection.select(population);
        for (Individual parent: parents) {
            System.out.println(parent);
        }
        Individual[] children = crossover.cross(parents);
        for (Individual child: children) {
            System.out.println(child);
        }
    }
}
