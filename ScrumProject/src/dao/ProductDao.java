package dao;

import models.Product;

import java.util.List;

public class ProductDao implements Dao<Product>{

    @Override
    public List<Product> readAll() {
        return List.of();
    }

    @Override
    public Product read(int id) {
        return null;
    }

    @Override
    public int create(Product product) {
        return 0;
    }

    @Override
    public void modify(int id, Product product) {

    }

    @Override
    public void delete(int id) {

    }
}
