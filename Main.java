import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Какое задание выполнить?\n1. В введенной матрице переставить местами элементы первого и последнего столбцов, если элементы первого столбца меньше элемента последнего столбца\n2. На основе введенной двумерной матрицы составить новую матрицу из четных строк исходной матрицы\n3. Отсортировать слова в предложении в порядке убывания их длины\n4. Найти минимальный положительный элемент введенной двумерной матрицы");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 3) {
            System.out.println("Введите текст для сортировки (или нажмите Enter для использования заготовленного предложения):");
            String input = sc.nextLine().trim();

            String text = input.isEmpty() ? Text.defaultText() : input;
            Text textObject = new Text(text);

            System.out.println("\nИсходное предложение:");
            textObject.printOriginal();  // Вывод первоначального предложения

            textObject.sortWordsByLength();  // Сортировка слов
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

            int[][] originalMatrix;
            if (choiceInputMethod.equals("y")) {
                originalMatrix = Matrix.generateRandomMatrix(numberOfRows, numberOfColumns);
            } else {
                originalMatrix = Matrix.inputMatrix(numberOfRows, numberOfColumns);
            }
	    
	        // Создаем копию матрицы перед изменениями
            Matrix matrixCopy = new Matrix(originalMatrix);

            switch (choice) {
                case 1:
                    matrixCopy.swapFirstLastColumns();
                    break;
                case 2:
                    matrixCopy.createEvenRowsMatrix();
                    break;
                case 4:
                    matrixCopy.findMinimalPositive();
                    break;
                default:
                    System.out.println("Неверный выбор задания.");
            }

            System.out.println("\nОригинальная матрица:");
            matrixCopy.outputMatrix();
        }
        sc.close();
    }
}
