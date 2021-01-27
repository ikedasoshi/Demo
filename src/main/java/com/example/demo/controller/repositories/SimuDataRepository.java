package com.example.demo.controller.repositories;

import com.example.demo.controller.simulator.SimuData;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimuDataRepository extends JpaRepository<SimuData, Long> {
    public Optional<SimuData> findById(Long name);
}