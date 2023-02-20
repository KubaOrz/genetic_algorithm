package sudoku;

import GeneticAlgorithmFramework.GeneticAlgorithm;
import GeneticAlgorithmFramework.Configuration.GeneticAlgorithmBuilder;
import GeneticAlgorithmFramework.Configuration.GeneticAlgorithmConfigurer;
import GeneticAlgorithmFramework.GeneticOperators.KBestSelection;
import GeneticAlgorithmFramework.GeneticOperators.TournamentPromotion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SudokuSolverTest {

    private static GeneticAlgorithm algorithm;

    @BeforeAll
    public static void configure() {
        GeneticAlgorithmConfigurer configurer = new GeneticAlgorithmConfigurer();
        GeneticAlgorithmBuilder builder = new GeneticAlgorithmBuilder();

        configurer.setNumberOfChildren(2)
                .setPopulationSize(400)
                .setNumberOfGenerations(1000)
                .setMutationFrequency(0.04)
                .setObjectiveFunction(new SudokuBoardCalculator())
                .saveSettings();

        builder.setGenerator(new SudokuBoardGenerator("src/test/resources/sudoku_test_cases/test_case_1"))
                .setSelection(new KBestSelection())
                .setCrossover(new SudokuBoardCrossover())
                .setPromotion(new TournamentPromotion())
                .setMutation(new SudokuBoardMutation());
        algorithm = builder.getProduct();
    }

    @Test
    public void firstTest() {
        algorithm.run();
    }

}
