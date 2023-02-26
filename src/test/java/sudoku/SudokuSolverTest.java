package sudoku;

import geneticAlgorithmFramework.GeneticAlgorithm;
import geneticAlgorithmFramework.configuration.GeneticAlgorithmBuilder;
import geneticAlgorithmFramework.configuration.GeneticAlgorithmConfigurer;
import geneticAlgorithmFramework.geneticOperators.DummyMutation;
import geneticAlgorithmFramework.geneticOperators.KBestSelection;
import geneticAlgorithmFramework.geneticOperators.TournamentPromotion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SudokuSolverTest {

    private static GeneticAlgorithmBuilder builder;

    @BeforeAll
    public static void configure() {
        GeneticAlgorithmConfigurer configurer = new GeneticAlgorithmConfigurer();
        builder = new GeneticAlgorithmBuilder();

        configurer.setNumberOfChildren(2)
                .setPopulationSize(400)
                .setNumberOfGenerations(1000)
                .setMutationFrequency(0.04)
                .setObjectiveFunction(new SudokuBoardCalculator())
                .saveSettings();

        builder.setSelection(new KBestSelection(0.1))
                .setCrossover(new SudokuBoardCrossover())
                .setPromotion(new TournamentPromotion())
                .setMutation(new DummyMutation())
                .setStopCondition(new SudokuStopCondition());
    }

    @Test
    public void should_SolveSudoku_WhenPuzzleGivenFromFile() {
        builder.setGenerator(new SudokuBoardGenerator("src/test/resources/sudoku_test_cases/test_case_1"));
        GeneticAlgorithm algorithm = builder.getProduct();
        algorithm.run();
    }

    @Test
    public void should_SolveSudoku_WhenGeneratedRandomPuzzleSample() {
        builder.setGenerator(new SudokuBoardGenerator());
        GeneticAlgorithm algorithm = builder.getProduct();
        algorithm.run();
    }

}
