package GeneticAlgorithmFramework.GeneticOperators;

import GeneticAlgorithmFramework.Configuration.GlobalSettings;
import GeneticAlgorithmFramework.Individual;

import java.util.Random;

public class RouletteSelection implements Selection {

    private final Random random;
    private final GlobalSettings settings;

    public RouletteSelection() {
        this.random = new Random();
        this.settings = GlobalSettings.getInstance();
    }

    @Override
    public Individual[] select(Individual[] population) {
        double [] fitnessLevels = new double[population.length];
        double totalPopulationFitness = 0;

        for (int i = 0; i < population.length; i++) {
            fitnessLevels[i] = 1 / population[i].getFitness();
            totalPopulationFitness += fitnessLevels[i];
        }

        fitnessLevels[0] /= totalPopulationFitness;
        for (int i = 1; i < population.length; i++) {
            fitnessLevels[i] /= totalPopulationFitness;
            fitnessLevels[i] += fitnessLevels[i - 1];
        }

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
