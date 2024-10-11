import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Какое задание выполнить?\n1. В введенной матрице переставить местами элементы первого и последнего столбцов, если элементы первого столбца меньше элемента последнего столбца\n2. На основе введенной двумерной матрицы составить новую матрицу из четных строк исходной матрицы\n3. Отсортировать слова в предложении в порядке убывания их длины\n4. Найти минимальный положительный элемент введенной двумерной матрицы");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 3) {
            System.out.println("Введите текст для сортировки:");
            String text = sc.nextLine();
            TextOperations.sortWordsByLength(text);
        } else {
            System.out.println("Введите число строк массива: ");
            int numberOfRows = sc.nextInt();
            System.out.println("Введите число столбцов массива: ");
            int numberOfColumns = sc.nextInt();
            sc.nextLine();

            String choiceInputMethod;
            do {
                System.out.println("Инициализировать матрицу автоматически? [Y/n]");
                choiceInputMethod = sc.nextLine().trim().toLowerCase();
            } while (!choiceInputMethod.equals("y") && !choiceInputMethod.equals("n"));

            int[][] matrix;
            if (choiceInputMethod.equals("y")) {
                matrix = MatrixOperations.generateRandomMatrix(numberOfRows, numberOfColumns);
            } else {
                matrix = MatrixOperations.inputMatrix(numberOfRows, numberOfColumns);
            }

            switch (choice) {
                case 1:
                    MatrixOperations.swapFirstLastColumns(matrix);
                    break;
                case 2:
                    MatrixOperations.createEvenRowsMatrix(matrix);
                    break;
                case 4:
                    MatrixOperations.findMinimalPositive(matrix);
                    break;
                default:
                    System.out.println("Неверный выбор задания.");
            }
        }
        sc.close();
    }
}
