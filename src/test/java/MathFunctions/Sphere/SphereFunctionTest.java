package MathFunctions.Sphere;

import GeneticAlgorithmFramework.GeneticAlgorithm;
import GeneticAlgorithmFramework.Configuration.GeneticAlgorithmBuilder;
import GeneticAlgorithmFramework.Configuration.GeneticAlgorithmConfigurer;
import GeneticAlgorithmFramework.GeneticOperators.KBestSelection;
import MathFunctions.SolutionGenerator;
import MathFunctions.ObjectiveFunctions.SphereFunction;
import MathFunctions.TwoVarCrossover;
import MathFunctions.TwoVarMutation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import GeneticAlgorithmFramework.GeneticOperators.TournamentPromotion;

public class SphereFunctionTest {

    private static GeneticAlgorithm algorithm;

    @BeforeAll
    public static void setUp() {
        GeneticAlgorithmConfigurer configurer = new GeneticAlgorithmConfigurer();
        GeneticAlgorithmBuilder builder = new GeneticAlgorithmBuilder();

        configurer.setNumberOfChildren(2)
                .setPopulationSize(100)
                .setNumberOfGenerations(100000)
                .setMutationFrequency(0.04)
                .setObjectiveFunction(new SphereFunction())
                .saveSettings();

        builder.setGenerator(new SolutionGenerator())
                .setSelection(new KBestSelection())
                .setCrossover(new TwoVarCrossover())
                .setPromotion(new TournamentPromotion())
                .setMutation(new TwoVarMutation());
        algorithm = builder.getProduct();
    }

    @Test
    public void sphereTest() {
        algorithm.run();
    }
}
