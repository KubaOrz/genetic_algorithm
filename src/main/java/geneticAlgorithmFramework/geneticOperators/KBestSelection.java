package geneticAlgorithmFramework.geneticOperators;

import geneticAlgorithmFramework.configuration.GlobalSettings;
import geneticAlgorithmFramework.Individual;

import java.util.Arrays;
import java.util.Random;

public class KBestSelection implements Selection {

    private final Random random;
    private final Individual[] bestIndividuals;
    private final int kBest;

    public KBestSelection(double crossingPercentage) {
        this.random = new Random();
        this.kBest = (int) (GlobalSettings.getInstance().getPopulationSize() * crossingPercentage);
        this.bestIndividuals = new Individual[kBest];
    }

    @Override
    public void rateIndividuals(Individual[] population) {
        Arrays.sort(population);
        System.arraycopy(population, 0, bestIndividuals, 0, kBest);
    }

    @Override
    public Individual[] select(Individual[] population) {
        int numberOfParents = GlobalSettings.NUMBER_OF_PARENTS;
        Individual[] parents = new Individual[numberOfParents];

        for (int i = 0; i < numberOfParents; i++) {
            parents[i] = bestIndividuals[random.nextInt(kBest)];
        }
        return parents;
    }
}
