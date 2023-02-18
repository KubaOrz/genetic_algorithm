package GeneticAlgorithmFramework.Configuration;

import GeneticAlgorithmFramework.GeneticAlgorithm;
import GeneticAlgorithmFramework.GeneticOperators.Crossover;
import GeneticAlgorithmFramework.GeneticOperators.Mutation;
import GeneticAlgorithmFramework.GeneticOperators.Promotion;
import GeneticAlgorithmFramework.GeneticOperators.Selection;
import GeneticAlgorithmFramework.PopulationGenerator;

public class GeneticAlgorithmBuilder {

    private Selection selection;
    private Crossover crossover;
    private Mutation mutation;
    private Promotion promotion;
    private PopulationGenerator generator;

    public GeneticAlgorithmBuilder setSelection(Selection selection) {
        this.selection = selection;
        return this;
    }

    public GeneticAlgorithmBuilder setCrossover(Crossover crossover) {
        this.crossover = crossover;
        return this;
    }

    public GeneticAlgorithmBuilder setMutation(Mutation mutation) {
        this.mutation = mutation;
        return this;
    }

    public GeneticAlgorithmBuilder setPromotion(Promotion promotion) {
        this.promotion = promotion;
        return this;
    }

    public GeneticAlgorithmBuilder setGenerator(PopulationGenerator generator) {
        this.generator = generator;
        return this;
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
