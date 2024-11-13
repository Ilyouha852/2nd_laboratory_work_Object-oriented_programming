import java.util.Random;
import java.util.Scanner;

public class Matrix {

    private int[][] matrix;
    private Scanner sc = new Scanner(System.in);

    public Matrix(int rows, int columns, boolean autoGenerate) {
        matrix = new int[rows][columns];
        if (autoGenerate) {
            generateRandomMatrix();
        } else {
            inputMatrix();
        }
    }

    // Метод для ввода матрицы
    private void inputMatrix() {
        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.nextLine(); // Очистка буфера
    }

    // Метод для автоматической инициализации матрицы
    private void generateRandomMatrix() {
        Random rnd = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rnd.nextInt(201) - 100;
            }
        }
    }

    public void outputMatrix() {
        outputMatrix(matrix);
    }

    public void outputMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    // Метод для перестановки первого и последнего столбцов
    public int[][] swapFirstLastColumns() {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] < matrix[i][matrix[i].length - 1]) {
                int temp = matrix[i][0];
                matrix[i][0] = matrix[i][matrix[i].length - 1];
                matrix[i][matrix[i].length - 1] = temp;
            }
        }
        return matrix;
    }

    // Метод для создания новой матрицы из четных строк
    public int[][] createEvenRowsMatrix() {
        int rows = matrix.length / 2;
        int columns = matrix[0].length;
        int[][] result = new int[rows][columns];
        for (int i = 1; i < matrix.length; i += 2) {
            for (int j = 0; j < columns; j++) {
                result[i / 2][j] = matrix[i][j];
            }
        }
        return result;
    }

    // Метод для поиска минимального положительного элемента
    public void findMinimalPositive() {
        int minimalNumber = Integer.MAX_VALUE;
        boolean foundPositive = false;

        for (int[] row : matrix) {
            for (int value : row) {
                if (value > 0 && value < minimalNumber) {
                    minimalNumber = value;
                    foundPositive = true;
                }
            }
        }

        if (foundPositive) {
            System.out.println("\nНаименьший положительный элемент матрицы = " + minimalNumber);
        } else {
            System.out.println("\nПоложительных элементов в матрице нет.");
        }
    }
}
