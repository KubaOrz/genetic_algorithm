package sudoku;

import GeneticAlgorithmFramework.Individual;
import GeneticAlgorithmFramework.Promotion;

import java.util.Random;

public class TournamentPromotion implements Promotion {

    private static Random random;

    public TournamentPromotion() {
        if (random == null) {
            random = new Random();
        }
    }

    @Override
    public Individual[] promote(Individual[] population) {
        int prevPopulationSize = population.length;
        int nextPopulationSize = population.length / 2;
        Individual[] nextPopulation = new Individual[nextPopulationSize];
        for (int i = 0; i < nextPopulationSize; i++) {
            Individual first = population[random.nextInt(prevPopulationSize)];
            Individual second = population[random.nextInt(prevPopulationSize)];
            if (first.getFitness() > second.getFitness()) {
                nextPopulation[i] = first;
            } else {
                nextPopulation[i] = second;
            }
        }
        return nextPopulation;
    }
}
