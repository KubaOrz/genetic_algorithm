package geneticAlgorithmFramework;

public interface PopulationGenerator {

    Individual[] generatePopulation(int number);

    Individual generateIndividual();
}
