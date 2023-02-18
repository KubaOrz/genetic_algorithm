package GeneticAlgorithmFramework.Configuration;

import GeneticAlgorithmFramework.ObjectiveFunction;

public class GlobalSettings {

    private static GlobalSettings instance;
    private int numberOfChildren;
    private int populationSize;
    private int numberOfGenerations;
    public static final int NUMBER_OF_PARENTS = 2;
    private double mutationFrequency;
    private ObjectiveFunction objectiveFunction;

    public static GlobalSettings getInstance() {
        if (instance == null) {
            throw new IllegalArgumentException();
        }
        return instance;
    }

    public static void createInstance(int numberOfChildren, int populationSize, int numberOfGenerations, int numberOfParents, double mutationFrequency, ObjectiveFunction function) {
        if (instance == null) {
            instance = new GlobalSettings(numberOfChildren, populationSize, numberOfGenerations, mutationFrequency, function);
        }
    }

    private GlobalSettings() {

    }

    private GlobalSettings(int numberOfChildren, int populationSize, int numberOfGenerations, double mutationFrequency, ObjectiveFunction function) {
        this.numberOfChildren = numberOfChildren;
        this.populationSize = populationSize;
        this.numberOfGenerations = numberOfGenerations;
        this.mutationFrequency = mutationFrequency;
        this.objectiveFunction = function;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public int getNumberOfGenerations() {
        return numberOfGenerations;
    }

    public double getMutationFrequency() {
        return mutationFrequency;
    }

    public ObjectiveFunction getObjectiveFunction() {
        return objectiveFunction;
    }
}
