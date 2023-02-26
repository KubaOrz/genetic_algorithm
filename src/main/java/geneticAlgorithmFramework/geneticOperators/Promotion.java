package geneticAlgorithmFramework.geneticOperators;

import geneticAlgorithmFramework.Individual;

public interface Promotion {

    Individual[] promote(Individual[] population);
}
