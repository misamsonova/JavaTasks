package org.example;

import java.util.List;

;

public class Main {

    public static void main(String[] args) {
        BasketList list = new BasketList();
        list.addProduct("Pen", 1800);
        list.addProduct("Pencil", 2100);
        list.addProduct("Copybook", 600);

        System.out.println(list.getProductQuantity("Pen"));
        System.out.println(list.getProductQuantity("Pencil"));
        System.out.println(list.getProductQuantity("Copybook"));

        list.addProduct("Pen",2700);
        list.updateProductQuantity("Copybook", 400);
        List<String> list1 = list.getProducts();
        for (String l: list1){
            System.out.println(l);
        }

        list.removeProduct("Pencil");
        List<String> list2 = list.getProducts();
        for (String l: list2){
            System.out.println(l);
        }
    }
}