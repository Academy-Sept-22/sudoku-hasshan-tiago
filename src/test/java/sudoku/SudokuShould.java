package sudoku;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class SudokuShould {

    @Mock
    private MatrixParser matrixParser;

    @Mock
    private Console console;

    @Test
    void detects_invalid_matrix() throws Exception {

        String matrix = "1,2,3,4,\n" +
                "2,1,4,3,\n" +
                "3,4,1,2,\n" +
                "4,3,2,1,\n";


        given(matrixParser.parse(matrix)).willThrow(new Exception("Invalid matrix"));
        Sudoku sudoku = new Sudoku(matrix, matrixParser, console);
        then(console).should().println("The input doesn't comply with Sudoku's rules.");
    }


    @Test
    void detects_valid_matrix() throws Exception {

        String matrix = "1,2,3,4,\n" +
                "3,4,1,2,\n" +
                "2,3,4,1,\n" +
                "4,1,2,3,\n";

        given(matrixParser.parse(matrix)).willReturn(new Matrix());
        Sudoku sudoku = new Sudoku(matrix, matrixParser, console);
        then(console).should().println("The input complies with Sudoku's rules.");
    }

}