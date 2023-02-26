package mathFunctions;

import geneticAlgorithmFramework.configuration.GlobalSettings;
import geneticAlgorithmFramework.Individual;
import geneticAlgorithmFramework.geneticOperators.Mutation;

import java.util.Random;

public class TwoVarMutation implements Mutation {

    private final Random random;
    private final GlobalSettings settings;
    private final double mutationRange;

    public TwoVarMutation(double mutationRange) {
        this.random = new Random();
        this.settings = GlobalSettings.getInstance();
        this.mutationRange = mutationRange;
    }

    @Override
    public Individual[] mutate(Individual[] population) {
        for (int i = 0; i < population.length; i++) {
            if (random.nextDouble() < settings.getMutationFrequency()) {
                TwoVarSolution individual = (TwoVarSolution) population[i];
                double x = individual.getX();
                double y = individual.getY();
                individual.setX(x * random.nextDouble(1 - mutationRange, 1 + mutationRange));
                individual.setY(y * random.nextDouble(1 - mutationRange, 1 + mutationRange));
                population[i] = individual;
            }
        }
        return population;
    }
}
