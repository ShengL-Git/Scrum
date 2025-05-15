package dao;

import java.util.List;

public interface dao<T> {
    List<T> readAll();
    T read();
    int create();
    void modify();
    void delete();
}
