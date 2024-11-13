public class Text {
    private String originalText;
    private String[] words;

    public Text(String text) {
            this.originalText = text;
            this.words = text.split("[\\s]+|(?=[\\W])|(?<=[\\W])");
    }
    public Text(){
        this("Today is a good day!");
    }

    // Метод для вывода исходного предложения
    public void printOriginal() {
        System.out.println(originalText);
    }
    public void sortWordsByLength() {
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

        printSorted();
    }

    // Метод для вывода отсортированных слов
    public void printSorted() {
        System.out.println("\nОтсортированные слова по длине:");
        for (String word : words) {
            if (word.length() == 0 || Character.isLetter(word.charAt(0))) {
                System.out.print(word + " ");
            }
        }
        System.out.println();
    }
}
