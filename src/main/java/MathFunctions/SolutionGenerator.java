package MathFunctions;

import GeneticAlgorithmFramework.Individual;
import GeneticAlgorithmFramework.PopulationGenerator;

import java.util.Random;

public class SolutionGenerator implements PopulationGenerator {

    private final Random random;

    public SolutionGenerator() {
        this.random = new Random();
    }

    @Override
    public Individual[] generatePopulation(int number) {
        Individual[] population = new Individual[number];
        for (int i = 0; i < number; i++) {
            population[i] = generateIndividual();
        }
        return population;
    }

    @Override
    public Individual generateIndividual() {
        double x = random.nextDouble(-10, 10);
        double y = random.nextDouble(-10, 10);
        return new TwoVarSolution(x, y);
    }

}
