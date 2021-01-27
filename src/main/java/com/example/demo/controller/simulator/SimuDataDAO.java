package com.example.demo.controller.simulator;

import java.io.Serializable;
import java.util.List;

public interface SimuDataDAO <T> extends Serializable {
    
    public List<T> getAll();
}