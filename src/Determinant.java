public class Determinant {

    static int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 15}
    };

    public static void main(String[] args) {
        try {
            int det = calculateMatrixDeterminant(matrix);
            showMatrix(matrix);
            System.out.println("Determinant = " + det);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            int sum = matrix[0][base];
            int row = 1, col = (base + 1) % columnLength;
            while (row < rowLength) {
                sum *= matrix[row][col];
                row++;
                col = (col + 1) % columnLength;
            }
            result += sum;

            // Subtractive process (Left)
            sum = matrix[0][base];
            row = 1;
            col = (base - 1 + columnLength) % columnLength;
            while (row < rowLength) {
                sum *= matrix[row][col];
                row++;
                col = (col - 1 + columnLength) % columnLength;
            }
            result -= sum;
        }

        return result;
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
    }
}
