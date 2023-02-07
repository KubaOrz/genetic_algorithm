package GeneticAlgorithmFramework;

public class GeneticAlgorithm {

    private Selection selection;
    private Mutation mutation;
    private Promotion promotion;
    private Crossover crossover;
    private Individual[] population;

    public GeneticAlgorithm(Selection selection, Mutation mutation, Promotion promotion, Crossover crossover) {
        this.selection = selection;
        this.mutation = mutation;
        this.promotion = promotion;
        this.crossover = crossover;
    }
}
