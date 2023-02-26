package mathFunctions;

import geneticAlgorithmFramework.Individual;
import geneticAlgorithmFramework.PopulationGenerator;

import java.util.Random;

public class SolutionGenerator implements PopulationGenerator {

    private final Random random;
    private final double xLowerLimit;
    private final double xUpperLimit;
    private final double yLowerLimit;
    private final double yUpperLimit;

    public SolutionGenerator(double lowerLimit, double upperLimit) {
        this.random = new Random();
        this.xLowerLimit = lowerLimit;
        this.xUpperLimit = upperLimit;
        this.yLowerLimit = lowerLimit;
        this.yUpperLimit = upperLimit;
    }

    public SolutionGenerator(double xLowerLimit, double xUpperLimit, double yLowerLimit, double yUpperLimit) {
        this.random = new Random();
        this.xLowerLimit = xLowerLimit;
        this.xUpperLimit = xUpperLimit;
        this.yLowerLimit = yLowerLimit;
        this.yUpperLimit = yUpperLimit;
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
        double x = random.nextDouble(xLowerLimit, xUpperLimit);
        double y = random.nextDouble(yLowerLimit, yUpperLimit);
        return new TwoVarSolution(x, y);
    }
}
