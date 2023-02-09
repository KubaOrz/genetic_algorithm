package sudoku;

import GeneticAlgorithmFramework.GeneticAlgorithm;
import GeneticAlgorithmFramework.GeneticAlgorithmConfigurer;
import GeneticAlgorithmFramework.RouletteSelection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SudokuSolverTest {

    private static GeneticAlgorithm algorithm;

    @BeforeAll
    public static void configure() {
        GeneticAlgorithmConfigurer configurer = new GeneticAlgorithmConfigurer();
        configurer.setGenerator(new SudokuBoardGenerator("src/test/resources/sudoku_test_cases/test_case_1"));
        configurer.setSelection(new RouletteSelection());
        configurer.setCrossover(new SudokuBoardCrossover());
        configurer.setMutation(new SudokuBoardMutation());
        configurer.setPromotion(new TournamentPromotion());
        algorithm = configurer.getProduct();
    }

    @Test
    public void firstTest() {
        algorithm.run();
    }
}
