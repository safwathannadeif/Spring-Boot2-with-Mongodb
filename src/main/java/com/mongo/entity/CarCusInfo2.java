package com.mongo.entity;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "carCusInfo2")
public class CarCusInfo2 {
    protected String carIdRef ;
    protected String  carColor ;
    protected Integer carMileage ;
    protected String platelicense  ;
    protected String dateOfSell ;
    protected Integer purchasePrice ;
    protected Integer bookValue ;
    protected String remark ;
    public String getCarIdRef() {
        return carIdRef;
    }
    public void setCarIdRef(String carIdRef) {
        this.carIdRef = carIdRef;
    }
    public String getCarColor() {
        return carColor;
    }
    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
    public Integer getCarMileage() {
        return carMileage;
    }
    public void setCarMileage(Integer carMileage) {
        this.carMileage = carMileage;
    }
    public String getPlatelicense() {
        return platelicense;
    }
    public void setPlatelicense(String platelicense) {
        this.platelicense = platelicense;
    }
    public String getDateOfSell() {
        return dateOfSell;
    }
    public void setDateOfSell(String dateOfSell) {
        this.dateOfSell = dateOfSell;
    }
    public Integer getPurchasePrice() {
        return purchasePrice;
    }
    public void setPurchasePrice(Integer purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    public Integer getBookValue() {
        return bookValue;
    }
    public void setBookValue(Integer bookValue) {
        this.bookValue = bookValue;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Override
    public String toString() {
        return "CarCusInfo2{" +
                "carIdRef='" + carIdRef + '\'' +
                ", carColor='" + carColor + '\'' +
                ", carMileage=" + carMileage +
                ", platelicense='" + platelicense + '\'' +
                ", dateOfSell='" + dateOfSell + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", bookValue=" + bookValue +
                ", remark='" + remark + '\'' +
                '}';
    }
    
}