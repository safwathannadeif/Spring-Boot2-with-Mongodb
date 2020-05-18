package com.mongo.entity;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "customers")
public class Customer {
        private String name;
        private String cusId;
        private List<CarCusInfo> lisOfCarInfo ;
        private List<String> refToCars ;
    public Customer() {
    }
    public Customer(String name, String cusId, List<CarCusInfo> lisOfCarInfo, List<String> refToCars) {
        this.name = name;
        this.cusId = cusId;
        this.lisOfCarInfo = lisOfCarInfo;
        this.refToCars = refToCars;
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
    public List<CarCusInfo> getLisOfCarInfo() {
        return lisOfCarInfo;
    }
    public void setLisOfCarInfo(List<CarCusInfo> lisOfCarInfo) {
        this.lisOfCarInfo = lisOfCarInfo;
    }
    public List<String> getRefToCars() {
        return refToCars;
    }
    public void setRefToCars(List<String> refToCars) {
        this.refToCars = refToCars;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", cusId='" + cusId + '\'' +
                ", lisOfCarInfo=" + lisOfCarInfo +
                ", refToCars=" + refToCars +
                '}';
    }
}
