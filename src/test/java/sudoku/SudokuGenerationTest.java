package sudoku;

import GeneticAlgorithmFramework.PopulationGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SudokuGenerationTest {

    private static PopulationGenerator generator;

    @BeforeAll
    static void setUp() {
        generator = new SudokuBoardGenerator();
    }

    @Test
    public void displayTest() {
        System.out.println(generator.generateIndividual());
    }
}
