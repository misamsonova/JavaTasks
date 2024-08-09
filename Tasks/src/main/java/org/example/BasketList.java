package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BasketList implements Basket{
    private Map<String, Integer> products;

    public BasketList() {
        this.products = new HashMap<>();
    }

    @Override
    public void addProduct(String product, int quantity) {
        if (products.containsKey(product)){
            int currentQuantity = products.get(product);
            products.put(product, currentQuantity + quantity);
        }
        else {
            products.put(product, quantity);
        }
    }

    @Override
    public void removeProduct(String product) {
        products.remove(product);
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        if (products.containsKey(product)) {
            products.put(product, quantity);
        } else {
            System.out.println("Товар \"" + product + "\" отсутствует в корзине.");
        }
    }

    @Override
    public void clear() {
        products.clear();
    }

    @Override
    public List<String> getProducts() {
        return new LinkedList<>(products.keySet());
    }

    @Override
    public int getProductQuantity(String product) {
        return products.getOrDefault(product,0);
    }
}
