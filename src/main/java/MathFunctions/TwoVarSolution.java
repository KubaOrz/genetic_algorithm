package MathFunctions;

import GeneticAlgorithmFramework.Configuration.GlobalSettings;
import GeneticAlgorithmFramework.Individual;
import GeneticAlgorithmFramework.ObjectiveFunction;

public class TwoVarSolution implements Individual {

    private double x;
    private double y;
    private double value;
    private final ObjectiveFunction function;

    public TwoVarSolution(double x, double y) {
        this.x = x;
        this.y = y;
        this.function = GlobalSettings.getInstance().getObjectiveFunction();
        this.value = function.calculateValue(this);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
        this.value = function.calculateValue(this);
    }

    public void setY(double y) {
        this.y = y;
        this.value = function.calculateValue(this);
    }

    @Override
    public double getFitness() {
        return value;
    }

    @Override
    public void setFitness(int fitness) {

    }

    @Override
    public int compareTo(Individual o) {
        return Double.compare(value, o.getFitness());
    }

    @Override
    public String toString() {
        return "x=" + x +
                ", y=" + y +
                ", value=" + value;
    }
}
