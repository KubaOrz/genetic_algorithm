package sudoku;

import GeneticAlgorithmFramework.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SudokuGenerationTest {

    private static PopulationGenerator generator;

    @BeforeAll
    static void setUp() {
        generator = new SudokuBoardGenerator();
    }

    @Test
    public void should_DisplayOneSudokuBoard() {
        System.out.println(generator.generateIndividual());
    }

    @Test
    public void should_DisplayPopulationOfSudokuBoards() {
        // given
        int populationSize = 20;

        // when
        Individual[] population = generator.generatePopulation(populationSize);
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
        Individual[] population = generator.generatePopulation(populationSize);
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
        Individual[] population = generator.generatePopulation(populationSize);
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
