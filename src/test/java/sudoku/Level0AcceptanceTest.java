package sudoku;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
public class Level0AcceptanceTest {

    @Mock private Console console;

    @Test
    void detects_invalid_matrix () {

        String matrix = "1,2,3,4,\n" +
                "2,1,4,3,\n" +
                "3,4,1,2,\n" +
                "4,3,2,1,";

        MatrixParser matrixParser = new MatrixParser();
        Sudoku sudoku = new Sudoku(matrix, matrixParser, console);

        then(console).should().println("The input doesn't comply with Sudoku's rules.");
    }

    @Test
    void detects_valid_matrix() {

        String matrix = "1,2,3,4,\n" +
                "3,4,1,2,\n" +
                "2,3,4,1,\n" +
                "4,1,2,3,";

        MatrixParser matrixParser = new MatrixParser();
        Sudoku sudoku = new Sudoku(matrix, matrixParser, console);

        then(console).should().println("The input complies with Sudoku's rules.");
    }
}
