package geneticAlgorithmFramework.constraints;

import geneticAlgorithmFramework.Individual;

public interface StopCondition {

    boolean shouldRun(Individual best);
}
