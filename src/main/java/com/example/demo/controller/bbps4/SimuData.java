package com.example.demo.controller.bbps4;

import javax.persistence.*;

@Entity
@Table(name = "simu_database")

public class SimuData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer power;
    @Column(nullable = false)
    private Integer rate;
    @Column(nullable = true)
    private String memo;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getPower() {
        return power;
    }
    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getRate() {
        return rate;
    }
    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }
}