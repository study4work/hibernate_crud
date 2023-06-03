package com.lysenko.repository;

import java.util.List;

public interface GenericRepository<T, ID> {

    T save(T t);

    T update(ID id, T t);

    T findById(ID id);

    List<T> findAll();

    void delete(ID id);
}
