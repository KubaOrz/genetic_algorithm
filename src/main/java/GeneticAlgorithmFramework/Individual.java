package GeneticAlgorithmFramework;

public interface Individual extends Comparable<Individual> {

    double getFitness();
    void setFitness(int fitness);
}
