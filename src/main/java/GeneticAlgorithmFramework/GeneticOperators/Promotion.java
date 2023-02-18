package GeneticAlgorithmFramework.GeneticOperators;

import GeneticAlgorithmFramework.Individual;

public interface Promotion {

    public Individual[] promote(Individual[] population);
}
