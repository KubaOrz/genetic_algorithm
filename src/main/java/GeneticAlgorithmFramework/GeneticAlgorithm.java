package GeneticAlgorithmFramework;

import GeneticAlgorithmFramework.Configuration.GeneticAlgorithmBuilder;
import GeneticAlgorithmFramework.Configuration.GlobalSettings;
import GeneticAlgorithmFramework.GeneticOperators.Crossover;
import GeneticAlgorithmFramework.GeneticOperators.Mutation;
import GeneticAlgorithmFramework.GeneticOperators.Promotion;
import GeneticAlgorithmFramework.GeneticOperators.Selection;

import java.util.ArrayList;
import java.util.List;

public class GeneticAlgorithm {

    private final Selection selection;
    private final Mutation mutation;
    private final Promotion promotion;
    private final Crossover crossover;
    private final PopulationGenerator generator;
    private Individual[] population;
    private final GlobalSettings settings;

    public GeneticAlgorithm(GeneticAlgorithmBuilder configuration) {
        this.generator = configuration.getGenerator();
        this.selection = configuration.getSelection();
        this.crossover = configuration.getCrossover();
        this.promotion = configuration.getPromotion();
        this.mutation = configuration.getMutation();
        this.settings = GlobalSettings.getInstance();
    }

    public void run() {
        int populations = settings.getNumberOfGenerations();
        population = generator.generatePopulation(settings.getPopulationSize());

        for (int i = 0; i < populations; i++) {
            List<Individual> newPopulation = new ArrayList<>();

            while (newPopulation.size() < settings.getPopulationSize() / GlobalSettings.NUMBER_OF_PARENTS * settings.getNumberOfChildren()) {
                Individual[] parents = selection.select(population);
                Individual[] children = crossover.cross(parents);
                //children = mutation.mutate(children);
                newPopulation.addAll(List.of(parents));
                newPopulation.addAll(List.of(children));
            }
            population = promotion.promote(newPopulation.toArray(new Individual[0]));
            Individual best = findBestIndividual();
            System.out.println(best);
        }
    }

    private Individual findBestIndividual() {
        Individual best = population[0];
        for (Individual individual: population) {
            if (individual.compareTo(best) < 0) {
                best = individual;
            }
        }
        return best;
    }
}
