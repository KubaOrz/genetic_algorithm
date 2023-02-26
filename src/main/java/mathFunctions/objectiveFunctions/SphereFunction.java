package mathFunctions.objectiveFunctions;

import geneticAlgorithmFramework.Individual;
import geneticAlgorithmFramework.ObjectiveFunction;
import mathFunctions.TwoVarSolution;

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
