package GeneticAlgorithmFramework;

import java.util.Random;

public class RouletteSelection implements Selection {

    private static Random random;

    public RouletteSelection() {
        if (random == null) {
            random = new Random();
        }
    }

    @Override
    public Individual[] select(Individual[] population) {
        double [] fitnessLevels = new double[population.length];
        double totalPopulationFitness = 0;

        for (int i = 0; i < population.length; i++) {
            fitnessLevels[i] = population[i].getFitness();
            totalPopulationFitness += fitnessLevels[i];
        }

        fitnessLevels[0] /= totalPopulationFitness;
        for (int i = 1; i < population.length; i++) {
            fitnessLevels[i] /= totalPopulationFitness;
            fitnessLevels[i] += fitnessLevels[i - 1];
        }

        Individual[] parents = new Individual[2];
        for (int i = 0; i < 2; i++) {
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
