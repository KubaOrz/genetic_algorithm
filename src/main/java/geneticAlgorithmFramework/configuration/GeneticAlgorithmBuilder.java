package geneticAlgorithmFramework.configuration;

import geneticAlgorithmFramework.GeneticAlgorithm;
import geneticAlgorithmFramework.constraints.StopCondition;
import geneticAlgorithmFramework.geneticOperators.Crossover;
import geneticAlgorithmFramework.geneticOperators.Mutation;
import geneticAlgorithmFramework.geneticOperators.Promotion;
import geneticAlgorithmFramework.geneticOperators.Selection;
import geneticAlgorithmFramework.PopulationGenerator;

public class GeneticAlgorithmBuilder {

    private Selection selection;
    private Crossover crossover;
    private Mutation mutation;
    private Promotion promotion;
    private PopulationGenerator generator;
    private StopCondition stopCondition;

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

    public GeneticAlgorithmBuilder setStopCondition(StopCondition stopCondition) {
        this.stopCondition = stopCondition;
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

    public StopCondition getStopCondition() {
        return stopCondition;
    }

    public GeneticAlgorithm getProduct() {
        return new GeneticAlgorithm(this);
    }
}
