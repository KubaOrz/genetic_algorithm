package GeneticAlgorithmFramework.GeneticOperators;

import GeneticAlgorithmFramework.Individual;

public interface Mutation {

    public Individual[] mutate(Individual[] population);
}
