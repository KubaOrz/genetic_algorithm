package GeneticAlgorithmFramework;

public interface PopulationGenerator {

    Individual[] generatePopulation(int number);

    Individual generateIndividual();
}
