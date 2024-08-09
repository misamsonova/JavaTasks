package Task2;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение числа книг
        int n = scanner.nextInt();

        // Чтение высот книг в виде массива
        int[] bookHeights = new int[n];
        for (int i = 0; i < n; i++) {
            bookHeights[i] = scanner.nextInt();
        }

        // Сортировка массива с высотами книг
        Arrays.sort(bookHeights);

        // Подсчет минимального числа стопок и их высот
        int minStacks = 0;
        int[] stackHeights = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0 || bookHeights[i] != bookHeights[i - 1]) {
                // Новая стопка
                stackHeights[minStacks++] = 1;
            } else {
                // Добавляем книгу в текущую стопку
                stackHeights[minStacks - 1]++;
            }
        }

        // Вывод результата в требуемом формате
        System.out.println(minStacks);

        // Создание и сортировка массива высот стопок
        int[] sortedStackHeights = Arrays.copyOf(stackHeights, minStacks);
        Arrays.sort(sortedStackHeights);

        for (int i = 0; i < minStacks; i++) {
            System.out.print(sortedStackHeights[i] + " ");
        }
    }
}

