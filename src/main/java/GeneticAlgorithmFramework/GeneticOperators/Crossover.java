package GeneticAlgorithmFramework.GeneticOperators;

import GeneticAlgorithmFramework.Individual;

public interface Crossover {

    Individual[] cross(Individual[] parents);
}
