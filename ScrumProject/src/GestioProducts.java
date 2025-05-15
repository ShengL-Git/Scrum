import models.Products;

import java.util.ArrayList;
import java.util.Scanner;

public class GestioProducts {
    private ArrayList<Products> products = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void addProduct(Products product) {
        products.add(product);
    }


    public void deleteProduct(String nameProduct) {
        for (Products product : products) {
            if (product.getName().equals(nameProduct)) {
                products.remove(product);
                break;
            }

        }
    }

    public void modifyPrice(String nameProduct, float newPrice) {
        for (Products product : products) {
            if (product.getName().equals(nameProduct)) {
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