package org.example;
import java.util.Scanner;

public class Algorithm {


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите размерность матрицы (N): ");
            int N = scanner.nextInt();

            int[][] matrix = generateMatrix(N);

            System.out.println("Сгенерированная матрица:");
            printMatrix(matrix);
        }

        public static int[][] generateMatrix(int N) {
            int[][] matrix = new int[N][N];

            for (int i = N-1; i >=0; i--) {
                for (int j = N-1; j >=0; j--) {
                    matrix[i][j] = Math.max(Math.max(i, j), Math.max(N - i - 1, N - j - 1))-(N/2);
                }
            }

            return matrix;
        }

        public static void printMatrix(int[][] matrix) {
            for (int[] row : matrix) {
                for (int cell : row) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
        }

}
