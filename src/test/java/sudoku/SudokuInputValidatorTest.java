package sudoku;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SudokuInputValidatorTest {

    private static Integer[][] board;

    @BeforeAll
    public static void setUp() {
        board = new Integer[][] {
                {5, 1, 8, 7, 6, 4, 2, null, 9},
                {2, 9, 6, null, 1, null, null, 4, null},
                {null, 4, 7, null, 8, 9, 3, 5, 6},
                {6, 8, null, 3, null, 2, 1, 9, 7},
                {1, null, 4, 6, null, null, 5, 8, 2},
                {7, null, 2, 8, 5, 1, 6, 3, null},
                {8, 7, 1, null, null, 6, 9, 2, null},
                {4, 2, 5, 9, 3, 8, null, 7, 1 },
                {9, null, 3, 1, 2, 7, null, 6, 4},
        };
    }

    @Test
    public void should_ReturnPossibleInputsCorrectly() {
        List<Integer> inputs = SudokuInputValidator.checkPossibleInputs(board, 4, 7);
        System.out.println(inputs);
        System.out.println(board[4][7]);
    }
}
