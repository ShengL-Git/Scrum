package dao;

import java.util.List;

public interface Dao<T> {
    List<T> readAll();
    T read(int id);
    int create(T t);
    void modify(int id, T t);
    void delete(int id);
}
