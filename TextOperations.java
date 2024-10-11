public class TextOperations {

    //TODO Решение задачи с текстом

    // Задача 3
        public static void sortWordsByLength(String text) {
            String[] words = text.split("[\\s]+|(?=[\\W])|(?<=[\\W])");
            int n = words.length;

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1 - i; j++) {
                    if (words[j].length() < words[j + 1].length()) {
                        String temp = words[j];
                        words[j] = words[j + 1];
                        words[j + 1] = temp;
                    }
                }
            }

            System.out.println("\nОтсортированные слова по длине:");
            for (String word : words) {
                if (Character.isLetter(word.charAt(0))) {
                    System.out.print(word + " ");
                }
            }
            System.out.println();
        }
    }
