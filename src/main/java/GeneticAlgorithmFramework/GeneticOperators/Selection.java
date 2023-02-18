package GeneticAlgorithmFramework.GeneticOperators;

import GeneticAlgorithmFramework.Individual;

public interface Selection {

    Individual[] select(Individual[] population);
}
