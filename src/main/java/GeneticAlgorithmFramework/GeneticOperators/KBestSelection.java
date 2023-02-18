package GeneticAlgorithmFramework.GeneticOperators;

import GeneticAlgorithmFramework.Configuration.GlobalSettings;
import GeneticAlgorithmFramework.Individual;

import java.util.Arrays;
import java.util.Random;

public class KBestSelection implements Selection {

    private final GlobalSettings settings;
    private final Random random;

    public KBestSelection() {
        this.settings = GlobalSettings.getInstance();
        this.random = new Random();
    }

    @Override
    public Individual[] select(Individual[] population) {
        int kBest = settings.getPopulationSize() / 10;
        int numberOfParents = GlobalSettings.NUMBER_OF_PARENTS;
        Individual[] toReproduce = new Individual[kBest];
        Arrays.sort(population);
        System.arraycopy(population, 0, toReproduce, 0, kBest);

        Individual[] parents = new Individual[numberOfParents];
        for (int i = 0; i < numberOfParents; i++) {
            parents[i] = toReproduce[random.nextInt(kBest)];
        }
        return parents;
    }
}
