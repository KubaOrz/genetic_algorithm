package geneticAlgorithmFramework.geneticOperators;

import geneticAlgorithmFramework.Individual;

public interface Crossover {

    Individual[] cross(Individual[] parents);
}
