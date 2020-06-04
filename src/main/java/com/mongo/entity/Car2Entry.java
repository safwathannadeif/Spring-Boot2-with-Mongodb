package com.mongo.entity;

public class Car2Entry {
    private int averagePrice;
    private int noOfCarsSold;
    private int noOfCarsAvailable ;
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(int averagePrice) {
        this.averagePrice = averagePrice;
    }

    public int getNoOfCarsSold() {
        return noOfCarsSold;
    }

    public void setNoOfCarsSold(int noOfCarsSold) {
        this.noOfCarsSold = noOfCarsSold;
    }

    public int getNoOfCarsAvailable() {
        return noOfCarsAvailable;
    }

    public void setNoOfCarsAvailable(int noOfCarsAvailable) {
        this.noOfCarsAvailable = noOfCarsAvailable;
    }

    @Override
    public String toString() {
        return "Car2Entry{" +
                "averagePrice=" + averagePrice +
                ", noOfCarsSold=" + noOfCarsSold +
                ", noOfCarsAvailable=" + noOfCarsAvailable +
                ", color='" + color + '\'' +
                '}';
    }
}
