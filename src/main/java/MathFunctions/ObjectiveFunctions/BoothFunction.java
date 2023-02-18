package MathFunctions.ObjectiveFunctions;

import GeneticAlgorithmFramework.Individual;
import GeneticAlgorithmFramework.ObjectiveFunction;
import MathFunctions.TwoVarSolution;

public class BoothFunction implements ObjectiveFunction {

    @Override
    public double calculateValue(Individual individual) {
        if (!(individual instanceof TwoVarSolution solution)) {
            throw new IllegalArgumentException();
        }
        double x = solution.getX();
        double y = solution.getY();

        return Math.pow(x + 2 * y - 7, 2) + Math.pow(2 * x + y - 5, 2);
    }
}
