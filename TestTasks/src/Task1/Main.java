package Task1;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение числа подарков
        int n = scanner.nextInt();

        // Создание массива для хранения информации о каждом подарке
        Gift[] gifts = new Gift[n];

        // Заполнение массива данными о каждом подарке
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt(); // день, в который придут материалы
            int c = scanner.nextInt(); // время, необходимое на приготовление подарка
            int s = scanner.nextInt(); // день, до которого нужно отправить подарок
            gifts[i] = new Gift(d, c, s, i + 1); // добавляем индекс подарка для вывода порядка отправки
        }

        // Сортировка подарков по возрастанию дня, до которого нужно отправить
        Arrays.sort(gifts, Comparator.comparingInt(gift -> gift.s));

        // Переменная, хранящая текущий день, на который Костя может отправить подарок
        int currentDay = 1;

        // Массив, содержащий день отправки для каждого подарка
        int[] sendingDays = new int[n];

        // Проверка возможности отправить все подарки вовремя
        for (Gift gift : gifts) {
            // Если текущий день больше дня, до которого нужно отправить подарок, то выводим "NO"
            if (currentDay > gift.s) {
                System.out.println("NO");
                return;
            }

            // Если день, когда придут материалы, больше текущего дня, устанавливаем текущий день равным дню прихода материалов
            if (gift.d > currentDay) {
                currentDay = gift.d;
            }

            // Увеличиваем текущий день на время, необходимое на приготовление подарка
            currentDay += gift.c;

            // Записываем день отправки для данного подарка
            sendingDays[gift.index - 1] = currentDay - gift.c; // вычитаем c, так как мы уже увеличили текущий день
        }

        // Вывод дней отправки для каждого подарка
        for (int day : sendingDays) {
            System.out.print(day + " ");
        }

        // Если все подарки были успешно отправлены, выводим "YES"
        System.out.println("\nYES");
    }

    // Класс, представляющий подарок
    static class Gift {
        int d; // день, в который придут материалы
        int c; // время, необходимое на приготовление подарка
        int s; // день, до которого нужно отправить подарок
        int index; // индекс подарка для вывода порядка отправки

        public Gift(int d, int c, int s, int index) {
            this.d = d;
            this.c = c;
            this.s = s;
            this.index = index;
        }
    }
}
