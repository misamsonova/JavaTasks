package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Workers {
    public static void main(String[] args) {
        List<Map<String, String>> table = Arrays.asList(
                Map.of("Имя", "Кирилл", "Возраст", "26", "Должность", "Middle java dev", "Зарплата", "150000 руб"),
                Map.of("Имя", "Виталий", "Возраст", "28", "Должность", "Senior java automation QA", "Зарплата", "2000$"),
                Map.of("Имя", "Александр", "Возраст", "31", "Должность", "junior functional tester", "Зарплата", "50000 руб"),
                Map.of("Имя", "Дементий", "Возраст", "35", "Должность", "dev-ops", "Зарплата", "1500$")
        );

        List<String> namesYoungerThan30 = table.stream()
                .filter(row -> Integer.parseInt(row.get("Возраст")) < 30)
                .map(row -> row.get("Имя"))
                .collect(Collectors.toList());
        System.out.println("1. Имена всех сотрудников, младше 30: ");
        for(String s: namesYoungerThan30){
            System.out.println(s);
        }

        List<String> namesWithSalaryInRubles = table.stream()
                .filter(row -> row.get("Зарплата").endsWith("руб"))
                .map(row -> row.get("Имя"))
                .collect(Collectors.toList());
        System.out.println("2. Имена всех сотрудников, получающих зарплату в рублях: ");
        for(String s: namesWithSalaryInRubles){
            System.out.println(s);
        }

        double averageAge = table.stream()
                .mapToDouble(row -> Double.parseDouble(row.get("Возраст")))
                .average()
                .orElse(0);
        System.out.println("3. Средний возраст всех сотрудников: " + averageAge);

    }
}
