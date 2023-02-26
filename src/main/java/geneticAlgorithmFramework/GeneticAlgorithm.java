package geneticAlgorithmFramework;

import geneticAlgorithmFramework.configuration.GeneticAlgorithmBuilder;
import geneticAlgorithmFramework.configuration.GlobalSettings;
import geneticAlgorithmFramework.constraints.StopCondition;
import geneticAlgorithmFramework.geneticOperators.Crossover;
import geneticAlgorithmFramework.geneticOperators.Mutation;
import geneticAlgorithmFramework.geneticOperators.Promotion;
import geneticAlgorithmFramework.geneticOperators.Selection;

import java.util.ArrayList;
import java.util.List;

public class GeneticAlgorithm {

    private final Selection selection;
    private final Mutation mutation;
    private final Promotion promotion;
    private final Crossover crossover;
    private final PopulationGenerator generator;
    private final StopCondition stopCondition;
    private Individual[] population;
    private final GlobalSettings settings;

    public GeneticAlgorithm(GeneticAlgorithmBuilder configuration) {
        this.generator = configuration.getGenerator();
        this.selection = configuration.getSelection();
        this.crossover = configuration.getCrossover();
        this.promotion = configuration.getPromotion();
        this.mutation = configuration.getMutation();
        this.stopCondition = configuration.getStopCondition();
        this.settings = GlobalSettings.getInstance();
    }

    public void run() {
        population = generator.generatePopulation(settings.getPopulationSize());
        Individual best = findBestIndividual();

        while (stopCondition.shouldRun(best)) {
            List<Individual> newPopulation = new ArrayList<>();
            selection.rateIndividuals(population);

            int desiredSize = settings.getPopulationSize() / GlobalSettings.NUMBER_OF_PARENTS * settings.getNumberOfChildren();
            while (newPopulation.size() < desiredSize) {
                Individual[] parents = selection.select(population);
                Individual[] children = crossover.cross(parents);
                children = mutation.mutate(children);
                newPopulation.addAll(List.of(parents));
                newPopulation.addAll(List.of(children));
            }
            population = promotion.promote(newPopulation.toArray(new Individual[0]));

            Individual prev = best;
            best = findBestIndividual();
            if (best.compareTo(prev) < 0) {
                System.out.println(best);
            }
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
