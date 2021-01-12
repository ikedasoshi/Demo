package com.example.demo.controller;

import javax.persistence.*;

@Entity
@Table(name = "mydata")
public class MyData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column
    private long id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 200, nullable = true)
    private String mail;
    @Column(nullable = true)
    private Integer age;
    @Column(nullable = true)
    private String memo;
}