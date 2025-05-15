import models.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class GestioProducts {
    private ArrayList<Product> products = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }


    public void deleteProduct(String nameProduct) {
        for (Product product : products) {
            if (product.getNameProduct().equals(nameProduct)) {
                products.remove(product);
                break;
            }

        }
    }

    public void modifyPrice(String nameProduct, float newPrice) {
        for (Product product : products) {
            if (product.getNameProduct().equals(nameProduct)) {
                product.setPrice(newPrice);
                return;
            }
        }
    }


    @Override
    public String toString() {
        return "GestioProducts{" +
                "products=" + products +
                '}';
    }


}