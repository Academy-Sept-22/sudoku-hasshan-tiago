package sudoku;

public class Sudoku {
    public Sudoku(String matrix, MatrixParser matrixParser, Console console) {

        try {
            matrixParser.parse(matrix);
            console.println("The input complies with Sudoku's rules.");
        } catch (Exception e) {
            console.println("The input doesn't comply with Sudoku's rules.");
        }

    }

}
