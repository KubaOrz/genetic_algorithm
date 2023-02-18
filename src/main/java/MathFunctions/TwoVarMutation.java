package MathFunctions;

import GeneticAlgorithmFramework.Configuration.GlobalSettings;
import GeneticAlgorithmFramework.Individual;
import GeneticAlgorithmFramework.GeneticOperators.Mutation;

import java.util.Random;

public class TwoVarMutation implements Mutation {

    private final Random random;
    private final GlobalSettings settings;

    public TwoVarMutation() {
        this.random = new Random();
        this.settings = GlobalSettings.getInstance();
    }

    @Override
    public Individual[] mutate(Individual[] population) {
        for (int i = 0; i < population.length; i++) {
            if (random.nextDouble() < settings.getMutationFrequency()) {
                TwoVarSolution individual = (TwoVarSolution) population[i];
                double x = individual.getX();
                double y = individual.getY();
                individual.setX(x * random.nextDouble(0.95, 1.05));
                individual.setY(y * random.nextDouble(0.95, 1.05));
                population[i] = individual;
            }
        }
        return population;
    }
}
