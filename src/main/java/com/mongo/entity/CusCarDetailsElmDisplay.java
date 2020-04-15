package com.mongo.entity;
public class CusCarDetailsElmDisplay extends CarCusInfo {
    private String brand;
    private String model;
    private int salesyear;
    public CusCarDetailsElmDisplay() {
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
    public int getSalesyear() {
        return salesyear;
    }
    public void setSalesyear(int salesyear) {
        this.salesyear = salesyear;
    }
    @Override
    public String toString() {
        return "CusCarDetails{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", salesyear=" + salesyear +
                ", carColor='" + carColor + '\'' +
                ", carMileage=" + carMileage +
                ", plateId='" + plateId + '\'' +
                '}';
    }
}
