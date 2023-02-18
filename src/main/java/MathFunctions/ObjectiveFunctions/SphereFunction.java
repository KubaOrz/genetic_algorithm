package MathFunctions.ObjectiveFunctions;

import GeneticAlgorithmFramework.Individual;
import GeneticAlgorithmFramework.ObjectiveFunction;
import MathFunctions.TwoVarSolution;

public class SphereFunction implements ObjectiveFunction {
    @Override
    public double calculateValue(Individual individual) {
        if (!(individual instanceof TwoVarSolution solution)) {
            throw new IllegalArgumentException();
        }
        double x = solution.getX();
        double y = solution.getY();

        return x * x + y * y;
    }
}
