package com.mongo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection ="cars2")
public class Car2 {
    private String carRefId ;
    private String brand;
    private String model;
    private int yearMade;
    private List<Car2Entry>  lisByColor ;

    public String getCarRefId() {
        return carRefId;
    }

    public void setCarRefId(String carRefId) {
        this.carRefId = carRefId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearMade() {
        return yearMade;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }

    public List<Car2Entry> getLisByColor() {
        return lisByColor;
    }

    public void setLisByColor(List<Car2Entry> lisByColor) {
        this.lisByColor = lisByColor;
    }

    @Override
    public String toString() {
        return "Car2{" +
                "carRefId='" + carRefId + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearMade=" + yearMade +
                ", lisByColor=" + lisByColor +
                '}';
    }
}
