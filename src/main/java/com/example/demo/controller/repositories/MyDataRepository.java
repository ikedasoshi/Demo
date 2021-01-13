package com.example.demo.controller.repositories;

import com.example.demo.controller.MyData;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {
    
}