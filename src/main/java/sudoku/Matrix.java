package sudoku;

import java.util.ArrayList;

public class Matrix {

    private ArrayList<int[]> lines = new ArrayList<>();

    public Matrix() {
    }

    public void addLine(int[] lineNumbers) {
        lines.add(lineNumbers);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] line: lines) {
            for (int number: line) {
                stringBuilder.append(number).append(",");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
