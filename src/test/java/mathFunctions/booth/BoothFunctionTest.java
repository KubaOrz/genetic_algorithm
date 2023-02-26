package mathFunctions.booth;

import geneticAlgorithmFramework.GeneticAlgorithm;
import geneticAlgorithmFramework.configuration.GeneticAlgorithmBuilder;
import geneticAlgorithmFramework.configuration.GeneticAlgorithmConfigurer;
import geneticAlgorithmFramework.constraints.NumOfPopulationsCondition;
import geneticAlgorithmFramework.geneticOperators.KBestSelection;
import mathFunctions.*;
import mathFunctions.objectiveFunctions.BoothFunction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import geneticAlgorithmFramework.geneticOperators.TournamentPromotion;

public class BoothFunctionTest {

    private static GeneticAlgorithm algorithm;

    @BeforeAll
    public static void setUp() {
        GeneticAlgorithmConfigurer configurer = new GeneticAlgorithmConfigurer();
        GeneticAlgorithmBuilder builder = new GeneticAlgorithmBuilder();

        configurer.setNumberOfChildren(2)
                .setPopulationSize(100)
                .setNumberOfGenerations(100000)
                .setMutationFrequency(0.04)
                .setObjectiveFunction(new BoothFunction())
                .saveSettings();

        builder.setGenerator(new SolutionGenerator(-10, 10))
                .setSelection(new KBestSelection(0.1))
                .setCrossover(new TwoVarCrossover())
                .setPromotion(new TournamentPromotion())
                .setMutation(new TwoVarMutation(0.05))
                .setStopCondition(new NumOfPopulationsCondition());
        algorithm = builder.getProduct();
    }

    @Test
    public void boothTest() {
        algorithm.run();
    }
}
