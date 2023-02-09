package GeneticAlgorithmFramework;

import java.util.Arrays;

public class GeneticAlgorithm {

    private final Selection selection;
    private final Mutation mutation;
    private final Promotion promotion;
    private final Crossover crossover;
    private final PopulationGenerator generator;
    private Individual[] population;

    public GeneticAlgorithm(GeneticAlgorithmConfigurer configuration) {
        this.generator = configuration.getGenerator();
        this.selection = configuration.getSelection();
        this.crossover = configuration.getCrossover();
        this.promotion = configuration.getPromotion();
        this.mutation = configuration.getMutation();
    }

    public void run() {
        int populations = 1000;
        population = generator.generatePopulation(400);
        for (int i = 0; i < populations; i++) {
            Individual[] newPopulation = new Individual[population.length * 2];
            int newPopulationSize = 0;
            while (newPopulationSize < population.length * 2) {
                Individual[] parents = selection.select(population);
                Individual[] children = crossover.cross(parents);
                children = mutation.mutate(children);
                System.arraycopy(parents, 0, newPopulation, newPopulationSize, parents.length);
                newPopulationSize += parents.length;
                System.arraycopy(children, 0, newPopulation, newPopulationSize , children.length);
                newPopulationSize += children.length;
            }
            population = promotion.promote(newPopulation);
            System.out.println(findBestIndividual());
        }
    }

    private Individual findBestIndividual() {
        Individual best = population[0];
        for (Individual individual: population) {
            if (individual.getFitness() > best.getFitness()) {
                best = individual;
            }
        }
        return best;
    }
}
