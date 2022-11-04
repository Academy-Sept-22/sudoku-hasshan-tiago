package sudoku;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixParserShould {

    @Test
    void parse_and_create_valid_matrix() throws Exception {

        String matrix = "1,2,3,4,\n" +
                "3,4,1,2,\n" +
                "2,3,4,1,\n" +
                "4,1,2,3,\n";

        MatrixParser matrixParser = new MatrixParser();
        Matrix matrixObj = matrixParser.parse(matrix);

        assertNotNull(matrixObj);
        assertEquals(matrix, matrixObj.toString());
    }

    @Test
    void throw_exception_for_2by2_matrix() throws Exception {

        String matrix = "1,2,\n" +
                "2,1,\n";

        MatrixParser matrixParser = new MatrixParser();
        Exception exception = assertThrows(Exception.class,
                () -> matrixParser.parse(matrix));
        assertEquals("Invalid size: 2!", exception.getMessage());
    }


    @Test
    void throw_exception_for_5by5_matrix() throws Exception {

        String matrix = "1,2,3,4,5\n" +
                "1,3,2,4,5\n" +
                "2,1,3,4,5\n" +
                "5,4,3,2,1\n" +
                "5,4,3,1,2\n";

        MatrixParser matrixParser = new MatrixParser();
        Exception exception = assertThrows(Exception.class,
                () -> matrixParser.parse(matrix));
        assertEquals("Invalid size: 5!", exception.getMessage());
    }

}