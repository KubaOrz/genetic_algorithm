package GeneticAlgorithmFramework;

public class GeneticAlgorithmConfigurer {

    private Selection selection;
    private Crossover crossover;
    private Mutation mutation;
    private Promotion promotion;
    private PopulationGenerator generator;

    public void setSelection(Selection selection) {
        this.selection = selection;
    }

    public void setCrossover(Crossover crossover) {
        this.crossover = crossover;
    }

    public void setMutation(Mutation mutation) {
        this.mutation = mutation;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public void setGenerator(PopulationGenerator generator) {
        this.generator = generator;
    }

    public Selection getSelection() {
        return selection;
    }

    public Crossover getCrossover() {
        return crossover;
    }

    public Mutation getMutation() {
        return mutation;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public PopulationGenerator getGenerator() {
        return generator;
    }

    public GeneticAlgorithm getProduct() {
        return new GeneticAlgorithm(this);
    }
}
