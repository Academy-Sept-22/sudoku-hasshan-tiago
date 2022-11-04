package sudoku;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.String.format;

public class MatrixParser {
    public Matrix parse(String matrix) throws Exception {

        try (Scanner scanner = new Scanner(matrix)) {
            Matrix matrixObj = new Matrix();
            while (scanner.hasNextLine()) {
                int[] lineValues = parseLine(scanner.nextLine());
                checkLineSize(lineValues);
                matrixObj.addLine(lineValues);
            }
            return matrixObj;
        }
    }

    private static void checkLineSize(int[] lineValues) throws Exception {
        int detectedSize = lineValues.length;
        if (lineValues.length < 4) {
            throw new Exception(format("Invalid size: %s!", detectedSize));
        }
    }

    private static int[] parseLine(String line) {
        String[] splittedLine = line.split(",");
        return Arrays.stream(splittedLine)
                .mapToInt(Integer::parseInt)
                .toArray();
    }


}
