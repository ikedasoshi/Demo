package com.example.demo.controller.simulator;

import javax.persistence.*;

@Entity
@Table(name = "simu_database")

public class SimuData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long s_id;
    @Column(length = 50, nullable = false)
    private String s_name;
    @Column(nullable = false)
    private Integer power;
    @Column(nullable = false)
    private Integer rate;
    @Column(nullable = true)
    private String memo;

    public long getId() {
        return s_id;
    }
    public void setId(long s_id) {
        this.s_id = s_id;
    }

    public String getName() {
        return s_name;
    }
    public void setName(String s_name) {
        this.s_name = s_name;
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