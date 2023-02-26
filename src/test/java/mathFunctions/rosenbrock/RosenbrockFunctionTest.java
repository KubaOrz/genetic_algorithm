package mathFunctions.rosenbrock;

import geneticAlgorithmFramework.GeneticAlgorithm;
import geneticAlgorithmFramework.constraints.NumOfPopulationsCondition;
import geneticAlgorithmFramework.configuration.GeneticAlgorithmBuilder;
import geneticAlgorithmFramework.configuration.GeneticAlgorithmConfigurer;
import geneticAlgorithmFramework.geneticOperators.KBestSelection;
import mathFunctions.objectiveFunctions.RosenbrockFunction;
import mathFunctions.SolutionGenerator;
import mathFunctions.TwoVarCrossover;
import mathFunctions.TwoVarMutation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import geneticAlgorithmFramework.geneticOperators.TournamentPromotion;

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

        builder.setGenerator(new SolutionGenerator(-10000, 10000))
                .setSelection(new KBestSelection(0.1))
                .setCrossover(new TwoVarCrossover())
                .setPromotion(new TournamentPromotion())
                .setMutation(new TwoVarMutation(0.05))
                .setStopCondition(new NumOfPopulationsCondition());
        algorithm = builder.getProduct();
    }

    @Test
    public void rosenbrockTest() {
        algorithm.run();
    }
}
