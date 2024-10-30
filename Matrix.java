import java.util.Random;
import java.util.Scanner;

public class Matrix {
    private int[][] matrix;

    public Matrix(int[][] original) {
        this.matrix = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                this.matrix[i][j] = original[i][j];
            }
        }
    }

    public static Scanner sc = new Scanner(System.in);

    // Метод для ввода матрицы
    public static int[][] inputMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.nextLine(); // Очистка буфера
        return matrix;
    }

    // Метод для автоматической инициализации матрицы
    public static int[][] generateRandomMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        Random rnd = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = rnd.nextInt(201) - 100;
            }
        }
        return matrix;
    }

    // Метод для вывода матрицы на экран
    public void outputMatrix() {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    // Копирование матрицы

    //TODO Задача 1 - Перестановка элементов первого и последнего столбцов, если элемент первого столбца меньше элемента последнего столбца
    public void swapFirstLastColumns() {
        System.out.println("\nИсходная матрица:");
        outputMatrix();

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] < matrix[i][matrix[i].length - 1]) {
                int temp = matrix[i][0];
                matrix[i][0] = matrix[i][matrix[i].length - 1];
                matrix[i][matrix[i].length - 1] = temp;
            }
        }

        System.out.println("\nПолученная матрица:");
        outputMatrix();
    }

    //TODO Задача 2 - Создание матрицы, состоящей из элементов четных строк исходящей матрицы
    public void createEvenRowsMatrix() {
        System.out.println("\nИсходная матрица:");
        outputMatrix();

        int rows = matrix.length / 2;
        int columns = matrix[0].length;
        int[][] result = new int[rows][columns];
        for (int i = 1; i < matrix.length; i += 2) {
            for (int j = 0; j < columns; j++) {
                result[i / 2][j] = matrix[i][j];
            }
        }

        System.out.println("\nПолученная матрица:");
        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    //TODO Задача 4 - Нахождение минимального положительного элемента в матрице
    public void findMinimalPositive() {
        System.out.println("\nИсходная матрица:");
        outputMatrix();

        int minimalNumber = Integer.MAX_VALUE;
        boolean foundPositive = false;  // Флаг для отслеживания наличия положительных элементов

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
