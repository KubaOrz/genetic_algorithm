package geneticAlgorithmFramework.constraints;

import geneticAlgorithmFramework.Individual;
import geneticAlgorithmFramework.configuration.GlobalSettings;

public class NumOfPopulationsCondition implements StopCondition {

    private int currentPopulation;
    private final int numberOfGenerations;

    public NumOfPopulationsCondition() {
        this.currentPopulation = 0;
        this.numberOfGenerations = GlobalSettings.getInstance().getNumberOfGenerations();
    }

    @Override
    public boolean shouldRun(Individual best) {
        return currentPopulation++ != numberOfGenerations;
    }
}
