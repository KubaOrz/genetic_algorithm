package geneticAlgorithmFramework.geneticOperators;

import geneticAlgorithmFramework.configuration.GlobalSettings;
import geneticAlgorithmFramework.Individual;

import java.util.Random;

public class TournamentPromotion implements Promotion {

    private final Random random;
    private final GlobalSettings settings;

    public TournamentPromotion() {
        this.random = new Random();
        this.settings = GlobalSettings.getInstance();
    }

    @Override
    public Individual[] promote(Individual[] population) {
        int prevPopulationSize = population.length;
        int nextPopulationSize = settings.getPopulationSize();
        Individual[] nextPopulation = new Individual[nextPopulationSize];

        for (int i = 0; i < nextPopulationSize; i++) {
            Individual first = population[random.nextInt(prevPopulationSize)];
            Individual second = population[random.nextInt(prevPopulationSize)];
            if (first.compareTo(second) < 0) {
                nextPopulation[i] = first;
            } else {
                nextPopulation[i] = second;
            }
        }
        return nextPopulation;
    }
}
