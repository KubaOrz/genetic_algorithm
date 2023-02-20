package MathFunctions.Rosenbrock;

import GeneticAlgorithmFramework.GeneticAlgorithm;
import GeneticAlgorithmFramework.Configuration.GeneticAlgorithmBuilder;
import GeneticAlgorithmFramework.Configuration.GeneticAlgorithmConfigurer;
import GeneticAlgorithmFramework.GeneticOperators.KBestSelection;
import MathFunctions.ObjectiveFunctions.RosenbrockFunction;
import MathFunctions.SolutionGenerator;
import MathFunctions.TwoVarCrossover;
import MathFunctions.TwoVarMutation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import GeneticAlgorithmFramework.GeneticOperators.TournamentPromotion;

public class RosenbrockFunctionTest {

    private static GeneticAlgorithm algorithm;

    @BeforeAll
    public static void setUp() {
        GeneticAlgorithmConfigurer configurer = new GeneticAlgorithmConfigurer();
        GeneticAlgorithmBuilder builder = new GeneticAlgorithmBuilder();

        configurer.setNumberOfChildren(2)
                .setPopulationSize(100)
                .setNumberOfGenerations(100000)
                .setMutationFrequency(0.04)
                .setObjectiveFunction(new RosenbrockFunction())
                .saveSettings();

        builder.setGenerator(new SolutionGenerator())
                .setSelection(new KBestSelection())
                .setCrossover(new TwoVarCrossover())
                .setPromotion(new TournamentPromotion())
                .setMutation(new TwoVarMutation());
        algorithm = builder.getProduct();
    }

    @Test
    public void rosenbrockTest() {
        algorithm.run();
    }
}
