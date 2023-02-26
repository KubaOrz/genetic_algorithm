package mathFunctions;

import geneticAlgorithmFramework.geneticOperators.Crossover;
import geneticAlgorithmFramework.configuration.GlobalSettings;
import geneticAlgorithmFramework.Individual;

import java.util.Random;

public class TwoVarCrossover implements Crossover {

    private final GlobalSettings settings;
    private final Random random;

    public TwoVarCrossover() {
        this.settings = GlobalSettings.getInstance();
        this.random = new Random();
    }

    @Override
    public Individual[] cross(Individual[] parents) {
        int numberOfParents = GlobalSettings.NUMBER_OF_PARENTS;
        int numberOfChildren = settings.getNumberOfChildren();

        TwoVarSolution[] parentSolutions = new TwoVarSolution[numberOfParents];
        Individual[] children = new Individual[numberOfParents];

        for (int i = 0; i < numberOfParents; i++) {
            parentSolutions[i] = (TwoVarSolution) parents[i];
        }

        for (int i = 0; i < numberOfChildren; i++) {
            double x1 = parentSolutions[0].getX();
            double x2 = parentSolutions[1].getX();
            double newX;
            if (x1 == x2) {
                newX = x1;
            } else {
                newX = random.nextDouble(Math.min(x1, x2), Math.max(x1, x2));
            }

            double y1 = parentSolutions[0].getY();
            double y2 = parentSolutions[1].getY();
            double newY;
            if (y1 == y2) {
                newY = y1;
            } else {
                newY = random.nextDouble(Math.min(y1, y2), Math.max(y1, y2));
            }
            children[i] = new TwoVarSolution(newX, newY);
        }
        return children;
    }
}
