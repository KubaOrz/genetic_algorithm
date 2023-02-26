package geneticAlgorithmFramework.geneticOperators;

import geneticAlgorithmFramework.Individual;

public class DummyMutation implements Mutation {

    @Override
    public Individual[] mutate(Individual[] population) {
        return population;
    }
}
