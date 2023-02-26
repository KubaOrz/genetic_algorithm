package sudoku;

import geneticAlgorithmFramework.Individual;
import geneticAlgorithmFramework.constraints.StopCondition;

public class SudokuStopCondition implements StopCondition {

    private int currentPopulation;

    @Override
    public boolean shouldRun(Individual best) {
        double desiredFitness = 0;
        int maxPopulations = 1000;
        if (currentPopulation == maxPopulations) {
            System.out.println("Solution not found!");
            return false;
        }
        currentPopulation++;
        return !(best.getFitness() == desiredFitness);
    }
}
