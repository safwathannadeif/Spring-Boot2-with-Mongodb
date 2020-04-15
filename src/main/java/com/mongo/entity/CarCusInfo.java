package com.mongo.entity;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "carCusInfos")
public class CarCusInfo {
    protected String  carColor ;
    protected int carMileage ;
    protected String plateId  ;

    public CarCusInfo() {
    }
    public CarCusInfo(String carColor, int carMileage, String plateId) {
        this.carColor = carColor;
        this.carMileage = carMileage;
        this.plateId = plateId;
    }
    public String getCarColor() {
        return carColor;
    }
    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
    public int getCarMileage() {
        return carMileage;
    }
    public void setCarMileage(int carMileage) {
        this.carMileage = carMileage;
    }
    public String getPlateId() {
        return plateId;
    }
    public void setPlateId(String plateId) {
        this.plateId = plateId;
    }
    @Override
    public String toString() {
        return "CarCusInfo{" +
                "carColor=" + carColor +
                ", carMileage=" + carMileage +
                ", plateId='" + plateId + '\'' +
                '}';
    }
}
