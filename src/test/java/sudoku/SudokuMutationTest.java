//package sudoku;
//
//import GeneticAlgorithmFramework.Individual;
//import GeneticAlgorithmFramework.GeneticOperators.Mutation;
//import GeneticAlgorithmFramework.PopulationGenerator;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//
//public class SudokuMutationTest {
//
//    private static Mutation mutation;
//    private static PopulationGenerator generator;
//
//    @BeforeAll
//    public static void setUp() {
//        mutation = new SudokuBoardMutation();
//        generator = new SudokuBoardGenerator("src/test/resources/sudoku_test_cases/test_case_1");
//    }
//
//    @Test
//    public void mutationTest() {
//        Individual[] boards = generator.generatePopulation(1);
//        System.out.println(Arrays.toString(boards));
//        Individual[] mutated = mutation.mutate(boards);
//        System.out.println(Arrays.toString(mutated));
//    }
//
//}
