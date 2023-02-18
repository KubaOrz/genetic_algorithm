package MathFunctions.Booth;

import GeneticAlgorithmFramework.GeneticAlgorithm;
import GeneticAlgorithmFramework.Configuration.GeneticAlgorithmBuilder;
import GeneticAlgorithmFramework.Configuration.GeneticAlgorithmConfigurer;
import GeneticAlgorithmFramework.GeneticOperators.KBestSelection;
import MathFunctions.*;
import MathFunctions.ObjectiveFunctions.BoothFunction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import GeneticAlgorithmFramework.GeneticOperators.TournamentPromotion;

public class BoothFunctionTest {

    private static GeneticAlgorithm algorithm;

    @BeforeAll
    public static void setUp() {
        GeneticAlgorithmConfigurer configurer = new GeneticAlgorithmConfigurer();
        GeneticAlgorithmBuilder builder = new GeneticAlgorithmBuilder();

        configurer.setNumberOfChildren(2)
                .setPopulationSize(100)
                .setNumberOfGenerations(10000000)
                .setMutationFrequency(0.04)
                .setObjectiveFunction(new BoothFunction())
                .saveSettings();

        builder.setGenerator(new SolutionGenerator())
                .setSelection(new KBestSelection())
                .setCrossover(new TwoVarCrossover())
                .setPromotion(new TournamentPromotion())
                .setMutation(new TwoVarMutation());
        algorithm = builder.getProduct();
    }

    @Test
    public void boothTest() {
        algorithm.run();
    }
}
