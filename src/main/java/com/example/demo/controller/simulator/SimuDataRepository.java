package com.example.demo.controller.simulator;

import com.example.demo.controller.simulator.SimuData;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimuDataRepository extends JpaRepository<SimuData, Long> {
    
}