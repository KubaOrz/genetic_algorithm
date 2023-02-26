package geneticAlgorithmFramework.configuration;

import geneticAlgorithmFramework.ObjectiveFunction;

public class GeneticAlgorithmConfigurer {

    private int numberOfChildren;
    private int populationSize;
    private int numberOfGenerations;
    private double mutationFrequency;
    private ObjectiveFunction objectiveFunction;

    public GeneticAlgorithmConfigurer() {
        this.numberOfChildren = 2;
        this.populationSize = 400;
        this.numberOfGenerations = 1000;
        this.mutationFrequency = (double) 1 / populationSize;
    }

    public GeneticAlgorithmConfigurer setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
        return this;
    }

    public GeneticAlgorithmConfigurer setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
        return this;
    }

    public GeneticAlgorithmConfigurer setNumberOfGenerations(int numberOfGenerations) {
        this.numberOfGenerations = numberOfGenerations;
        return this;
    }

    public GeneticAlgorithmConfigurer setMutationFrequency(double mutationFrequency) {
        this.mutationFrequency = mutationFrequency;
        return this;
    }

    public GeneticAlgorithmConfigurer setObjectiveFunction(ObjectiveFunction function) {
        this.objectiveFunction = function;
        return this;
    }

    public void saveSettings() {
        GlobalSettings.createInstance(numberOfChildren, populationSize, numberOfGenerations, mutationFrequency, objectiveFunction);
    }

}
