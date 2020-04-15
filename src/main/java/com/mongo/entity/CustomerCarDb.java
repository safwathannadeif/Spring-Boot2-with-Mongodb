package com.mongo.entity;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "customercars")
public class CustomerCarDb {
    private String name;
    private String cusId;
    private List<CarCusInfo> lisOfCarInfo ;
    private List<Long> refToCars ;
    private List<Car>  carsDbResult ;  //Should be the as in lookup parm # 4

    public CustomerCarDb() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCusId() {
        return cusId;
    }
    public void setCusId(String cusId) {
        this.cusId = cusId;
    }
    public List<Car> getLisOfFoundCars() {
        return carsDbResult;
    }
    public void setLisOfFoundCars(List<Car> lisOfFoundCars) {
        this.carsDbResult = lisOfFoundCars;
    }
    public List<CarCusInfo> getLisOfCarInfo() {
        return lisOfCarInfo;
    }
    public void setLisOfCarInfo(List<CarCusInfo> lisOfCarInfo) {
        this.lisOfCarInfo = lisOfCarInfo;
    }
    public List<Long> getRefToCars() {
        return refToCars;
    }
    public void setRefToCars(List<Long> refToCars) {
        this.refToCars = refToCars;
    }
    public List<Car> getCars() {
        return carsDbResult;
    }
    public void setCars(List<Car> cars) {
        this.carsDbResult = cars;
    }
    @Override
    public String toString() {
        return "CustomerCar{" +
                "name='" + name + '\'' +
                ", cusId='" + cusId + '\'' +
                ", lisOfCarInfo=" + lisOfCarInfo +
                ", refToCars=" + refToCars +
                ", cars=" + carsDbResult +
                '}';
    }
}