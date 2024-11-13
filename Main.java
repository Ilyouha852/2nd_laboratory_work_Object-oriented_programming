import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Какое задание выполнить?\n1. В введенной матрице переставить местами элементы первого и последнего столбцов, если элементы первого столбца меньше элемента последнего столбца\n2. На основе введенной двумерной матрицы составить новую матрицу из четных строк исходной матрицы\n3. Отсортировать слова в предложении в порядке убывания их длины\n4. Найти минимальный положительный элемент введенной двумерной матрицы");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 3) {
            System.out.println("Введите текст для сортировки (или нажмите Enter для использования заготовленного предложения):");
            String text = sc.nextLine().trim();

            Text textObject;
            if(text.isEmpty()){
             textObject= new Text();}
            else{
                textObject = new Text(text);
            }
            System.out.println("\nИсходное предложение:");
            textObject.printOriginal();
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

            Matrix matrix;
            if (choiceInputMethod.equals("y")) {
                matrix = new Matrix(numberOfRows, numberOfColumns, true);
            } else {
                matrix = new Matrix(numberOfRows, numberOfColumns, false);
            }

            switch (choice) {
                case 1:
                    System.out.println("\nИсходная матрица:\n");
                    matrix.outputMatrix();
                    System.out.println("\nРезультат:\n");
                    matrix.outputMatrix(matrix.swapFirstLastColumns());
                    break;
                case 2:
                    System.out.println("\nИсходная матрица:\n");
                    matrix.outputMatrix();
                    System.out.println("\nРезультат:\n");
                    matrix.outputMatrix(matrix.createEvenRowsMatrix());
                    break;
                case 4:
                    System.out.println("\nИсходная матрица:");
                    matrix.outputMatrix();
                    matrix.findMinimalPositive();
                    break;
                default:
                    System.out.println("Неверный выбор задания.");
            }
        }
        sc.close();
    }
}
