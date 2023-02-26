package mathFunctions.sphere;

import geneticAlgorithmFramework.GeneticAlgorithm;
import geneticAlgorithmFramework.configuration.GeneticAlgorithmBuilder;
import geneticAlgorithmFramework.configuration.GeneticAlgorithmConfigurer;
import geneticAlgorithmFramework.constraints.NumOfPopulationsCondition;
import geneticAlgorithmFramework.geneticOperators.RouletteSelection;
import mathFunctions.SolutionGenerator;
import mathFunctions.objectiveFunctions.SphereFunction;
import mathFunctions.TwoVarCrossover;
import mathFunctions.TwoVarMutation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import geneticAlgorithmFramework.geneticOperators.TournamentPromotion;

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

        builder.setGenerator(new SolutionGenerator(Integer.MIN_VALUE, Integer.MAX_VALUE))
                .setSelection(new RouletteSelection())
                .setCrossover(new TwoVarCrossover())
                .setPromotion(new TournamentPromotion())
                .setMutation(new TwoVarMutation(0.05))
                .setStopCondition(new NumOfPopulationsCondition());
        algorithm = builder.getProduct();
    }

    @Test
    public void sphereTest() {
        algorithm.run();
    }
}
