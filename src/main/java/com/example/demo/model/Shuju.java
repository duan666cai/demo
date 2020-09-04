package com.example.demo.model;

import lombok.Data;

@Data
public class Shuju {

    private int id;
    private String biaoti;
    private String leirong;

    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti;
    }

    public String getBiaoti() {
        return biaoti;
    }

    public void setLeirong(String leirong) {
        this.leirong = leirong;
    }

    public String getLeirong() {
        return leirong;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}