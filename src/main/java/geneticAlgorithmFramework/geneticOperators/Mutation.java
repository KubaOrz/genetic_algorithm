package geneticAlgorithmFramework.geneticOperators;

import geneticAlgorithmFramework.Individual;

public interface Mutation {

    Individual[] mutate(Individual[] population);
}
