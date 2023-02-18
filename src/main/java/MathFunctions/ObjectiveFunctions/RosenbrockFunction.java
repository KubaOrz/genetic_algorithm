package MathFunctions.ObjectiveFunctions;

import GeneticAlgorithmFramework.Individual;
import GeneticAlgorithmFramework.ObjectiveFunction;
import MathFunctions.TwoVarSolution;

public class RosenbrockFunction implements ObjectiveFunction {

    @Override
    public double calculateValue(Individual individual) {
        if (!(individual instanceof TwoVarSolution solution)) {
            throw new IllegalArgumentException();
        }
        double x = solution.getX();
        double y = solution.getY();

        return Math.pow(1 - solution.getX(), 2) + 100 * Math.pow(y - x * x, 2);
    }
}
