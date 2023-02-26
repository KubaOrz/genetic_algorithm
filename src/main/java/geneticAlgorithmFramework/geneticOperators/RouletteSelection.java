package geneticAlgorithmFramework.geneticOperators;

import geneticAlgorithmFramework.configuration.GlobalSettings;
import geneticAlgorithmFramework.Individual;

import java.util.Random;

public class RouletteSelection implements Selection {

    private final Random random;
    private final double[] fitnessLevels;
    private final int populationSize;

    public RouletteSelection() {
        this.random = new Random();
        this.populationSize = GlobalSettings.getInstance().getPopulationSize();
        this.fitnessLevels = new double[populationSize];
    }

    @Override
    public void rateIndividuals(Individual[] population) {
        double totalPopulationFitness = 0;

        for (int i = 0; i < populationSize; i++) {
            fitnessLevels[i] = 1 / population[i].getFitness();
            totalPopulationFitness += fitnessLevels[i];
        }

        fitnessLevels[0] /= totalPopulationFitness;
        for (int i = 1; i < populationSize; i++) {
            fitnessLevels[i] /= totalPopulationFitness;
            fitnessLevels[i] += fitnessLevels[i - 1];
        }
    }

    @Override
    public Individual[] select(Individual[] population) {

        Individual[] parents = new Individual[GlobalSettings.NUMBER_OF_PARENTS];
        for (int i = 0; i < GlobalSettings.NUMBER_OF_PARENTS; i++) {
            double rouletteDraw = random.nextDouble();
            int rouletteSection = 0;
            while (fitnessLevels[rouletteSection] < rouletteDraw) {
                rouletteSection++;
            }
            parents[i] = population[rouletteSection];
        }
        return parents;
    }
}
