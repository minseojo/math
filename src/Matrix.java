import java.util.Arrays;

public class Matrix {

    static int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 15}
    };

    public static void main(String[] args) {
        try {
            System.out.println("--- Default Matrix ---");
            showMatrix(matrix);

            int det = calculateMatrixDeterminant(matrix);
            System.out.println("determinant = " + det + "\n");

            System.out.println("--- Cofactor Matrix ---");
            showMatrix(makeCofactorMatrix(matrix));

            System.out.println("--- Adjoint Matrix ---");
            showMatrix(makeAdjointMatrix(matrix));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static boolean isValidMatrix(int[][] matrix) {
        return matrix != null && matrix.length > 0 && matrix[0].length > 0 && matrix.length == matrix[0].length;
    }

    static void showMatrix(int[][] matrix) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        for (int i = 0; i < rowLength; i++) {
            System.out.print("[");
            for (int j = 0; j < columnLength; j++) {
                System.out.print(j != columnLength - 1 ? matrix[i][j] + ", " : matrix[i][j]);
            }
            System.out.println("]");
        }

        System.out.println();
    }

    static int calculateMatrixDeterminant(int[][] matrix) {
        if (!isValidMatrix(matrix)) {
            throw new IllegalArgumentException("Invalid Matrix");
        }

        int result = 0;
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        for (int base = 0; base < columnLength; base++) {
            // Additive process (Right)
            int product = matrix[0][base];
            int row = 1, col = (base + 1) % columnLength;
            while (row < rowLength) {
                product *= matrix[row][col];
                row++;
                col = (col + 1) % columnLength;
            }
            result += product;

            // Subtractive process (Left)
            product = matrix[0][base];
            row = 1;
            col = (base - 1 + columnLength) % columnLength;
            while (row < rowLength) {
                product *= matrix[row][col];
                row++;
                col = (col - 1 + columnLength) % columnLength;
            }
            result -= product;
        }

        return result;
    }

    static int[][] makeCofactorMatrix(int[][] matrix) {
        if (!isValidMatrix(matrix)) {
            throw new IllegalArgumentException("Invalid Matrix");
        }

        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        int[][] result = new int[rowLength][columnLength];

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < columnLength; col++) {
                int product = 1;
                int y = (row + 1) % rowLength;
                int x = (col + 1) % columnLength;
                int calculateCount = 0;
                while (calculateCount < rowLength - 1) {
                    product *= matrix[y][x];
                    y = (y + 1) % rowLength;
                    x = (x + 1) % columnLength;
                    calculateCount++;
                }
                result[row][col] += product;

                product = 1;
                y = (row + 1) % rowLength;
                x = (col - 1 + columnLength) % columnLength;
                calculateCount = 0;
                while (calculateCount < rowLength - 1) {
                    product *= matrix[y][x];
                    y = (y + 1) % rowLength;
                    x = (x - 1 + columnLength) % columnLength;
                    calculateCount++;
                }
                result[row][col] -= product;
            }
        }

        return result;
    }

    static int[][] makeAdjointMatrix(int[][] matrix) {
        if (!isValidMatrix(matrix)) {
            throw new IllegalArgumentException("Invalid Matrix");
        }

        int[][] cofactorMatrix = makeCofactorMatrix(matrix);
        return transposeMatrix(cofactorMatrix);
    }

    static int[][] transposeMatrix(int[][] matrix) {
        if (!isValidMatrix(matrix)) {
            throw new IllegalArgumentException("Invalid Matrix");
        }

        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        int[][] result = new int[rowLength][columnLength];

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < columnLength; col++) {
                result[row][col] = matrix[col][row];
            }
        }

        return result;
    }

}
