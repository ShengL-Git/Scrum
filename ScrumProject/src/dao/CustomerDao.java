package dao;

import models.Customer;

import java.util.List;

public class CustomerDao implements Dao<Customer> {

    @Override
    public List<Customer> readAll() {
        return List.of();
    }

    @Override
    public Customer read(int id) {
        return null;
    }

    @Override
    public int create(Customer customer) {
        return 0;
    }

    @Override
    public void modify(int id, Customer customer) {

    }

    @Override
    public void delete(int id) {

    }
}
