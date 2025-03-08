import java.util.Scanner;

public class addmatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        int rows = 2, cols = 2;
        //int[][] matrix1 = new int[rows][cols];
        //int[][] matrix2 = new int[rows][cols];
        int[][] result = new int[rows][cols];

        int[][] matrix1 = { { 1, 2 }, { 3, 4 } };
        

        
        // System.out.println("Enter elements of first matrix:");
        // for (int i = 0; i < rows; i++) {
        //     for (int j = 0; j < cols; j++) {
        //         matrix1[i][j] = scanner.nextInt();
        //     }
        // }

        
        
        // System.out.println("Enter elements of second matrix:");
        // for (int i = 0; i < rows; i++) {
        //     for (int j = 0; j < cols; j++) {
        //         matrix2[i][j] = scanner.nextInt();
        //     }
        // }

        int[][] matrix2 = { { 5, 6 }, { 7, 8 } };
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        
        System.out.println("Sum of matrices:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
