package com.example.demo;

import java.io.Serializable;
import java.util.List;

public interface MyDataDAO <T> extends Serializable {
    public List<T> getAll();
    public T findById(long id);
    public List<T> findByName(String name);
}