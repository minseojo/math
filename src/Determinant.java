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
            System.out.println(e.getMessage());
        }
    }

    static int calculateMatrixDeterminant(int[][] matrix) {
        if (!isValidMatrix(matrix)) {
            throw new IllegalArgumentException("Invalid Matrix");
        }

        int result = 0;
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        // Additive process (Right)
        for (int i = 0; i < columnLength; i++) {
            int sum = matrix[0][i];
            int j = 1, k = (i + 1) % columnLength;
            while (j < rowLength) {
                sum *= matrix[j][k];
                j++;
                k = (k + 1) % columnLength;
            }
            result += sum;
        }

        // Subtractive process (Left)
        for (int i = 0; i < columnLength; i++) {
            int sum = matrix[0][i];
            int j = 1, k = (i - 1 + columnLength) % columnLength;
            while (j < rowLength) {
                sum *= matrix[j][k];
                j++;
                k = (k - 1 + columnLength) % columnLength;
            }
            result -= sum;
        }

        return result;
    }

    static boolean isValidMatrix(int[][] matrix) {
        return matrix != null && matrix.length > 0 && matrix[0].length > 0;
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
