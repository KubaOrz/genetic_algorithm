package geneticAlgorithmFramework.geneticOperators;

import geneticAlgorithmFramework.Individual;

public interface Selection {

    void rateIndividuals(Individual[] population);

    Individual[] select(Individual[] population);
}
