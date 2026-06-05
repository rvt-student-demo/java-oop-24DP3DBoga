package OnlineShop;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<String, Item> products;

    public ShoppingCart() {
        products = new HashMap<>();
    }

    public void add(String product, int price) {
        products.putIfAbsent(product, new Item(product, 0, price));
        products.get(product).increaseQuantity();
    }

    public int price() {
        int totalPrice = 0;
        for (Item product : products.values()) {
            totalPrice += product.price();
        }
        return totalPrice;
    }

    public void print() {
        for (Item product : products.values()) {
            System.out.println(product);
        }
    }
}