package mathFunctions.objectiveFunctions;

import geneticAlgorithmFramework.Individual;
import geneticAlgorithmFramework.ObjectiveFunction;
import mathFunctions.TwoVarSolution;

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
