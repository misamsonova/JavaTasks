package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinElement {
    static List<List<Integer>> adjList;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Задайте N - размер квадратичной матрицы: ");
        int N = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                N = scanner.nextInt();
                if (N > 1) {
                    break;
                } else {
                    System.out.println("Пожалуйста, введите целое число для размера матрицы больше 1.");
                }
            } else {
                System.out.println("Пожалуйста, введите целое число для размера матрицы.");
                scanner.next();
            }
        }


        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        System.out.println("Задайте элементы квадратичной матрицы: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                while (true) {
                    if (scanner.hasNext()) {
                        int u = scanner.nextInt();
                        adjList.get(i).add(u);
                        break;
                    } else {
                        System.out.println("Пожалуйста, введите целое число для элемента матрицы. " );
                        scanner.next(); // очистка буфера сканнера
                    }
                }
            }
        }

        int minElement = adjList.get(N-1).get(0);
        for (int i = 0; i < N; i++){
            for (int j = N-1; j >= 0; j--){
                if (i+j == N-1 && i!=j && adjList.get(i).get(j)<minElement){
                    minElement = adjList.get(i).get(j);
                }
            }
        }

        System.out.println("minElement: " + minElement);

    }
}
