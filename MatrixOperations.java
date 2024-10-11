import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {
        public static Scanner sc = new Scanner(System.in);

        //TODO Ввод-вывод матрицы

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
            Random rnd = new Random();
            int[][] matrix = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = rnd.nextInt(201) - 100;
                }
            }
            return matrix;
        }

        // Метод для вывода матрицы на экран
        public static void outputMatrix(int[][] matrix) {
            for (int[] row : matrix) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }

    //TODO Решение задач с матрицей

    // Задача 1
    public static void swapFirstLastColumns(int[][] matrix) {
        System.out.println("\nИсходная матрица:");
        outputMatrix(matrix);

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] < matrix[i][matrix[i].length - 1]) {
                int temp = matrix[i][0];
                matrix[i][0] = matrix[i][matrix[i].length - 1];
                matrix[i][matrix[i].length - 1] = temp;
            }
        }

        System.out.println("\nПолученная матрица:");
        outputMatrix(matrix);
    }

    // Задача 2
    public static void createEvenRowsMatrix(int[][] matrix) {
        System.out.println("\nИсходная матрица:");
        outputMatrix(matrix);

        int rows = matrix.length / 2;
        int columns = matrix[0].length;
        int[][] result = new int[rows][columns];
        for (int i = 1; i < matrix.length; i += 2) {
            for (int j = 0; j < columns; j++) {
                result[i / 2][j] = matrix[i][j];
            }
        }

        System.out.println("\nПолученная матрица:");
        outputMatrix(result);
    }

    // Задача 4
    public static void findMinimalPositive(int[][] matrix) {
    	System.out.println("\nИсходная матрица:");
    	outputMatrix(matrix);

    	int minimalNumber = Integer.MAX_VALUE;
    	boolean foundPositive = false;  // Флаг для отслеживания наличия положительных элементов

    	for (int[] row : matrix) {
        	for (int value : row) {
			if (value > 0 && value < minimalNumber) {
                		minimalNumber = value;
                		foundPositive = true;  // Устанавливаем флаг, если найден положительный элемент
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
