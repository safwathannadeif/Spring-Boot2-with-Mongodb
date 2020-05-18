package com.mongo.entity;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cars")
public class Car {
	private String carRefId ;
	private String brand;
	private String model;
	private int averagePrice; //averagePrice
	private int yearMade;
	private int noOfCarsSold ;
	public Car(String carRefId, String brand, String model, int averagePrice, int yearMade,int sold) {
		this.carRefId = carRefId;
		this.brand = brand;
		this.model = model;
		this.averagePrice = averagePrice;
		this.yearMade = yearMade;
		this.noOfCarsSold=sold ;
	}
	public Car() {
	}
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
	public int getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(int averagePrice) {
		this.averagePrice = averagePrice;
	}
	public int getYearMade() {
		return yearMade;
	}
	public void setYearMade(int yearMade) {
		this.yearMade = yearMade;
	}
	public int getNoOfCarsSold() { return noOfCarsSold ;} ;
	public void setNoOfCarsSold(int noOfCarsSold) { this.noOfCarsSold = noOfCarsSold;} ;
	@Override
	public String toString() {
		return "Car{" +
				"carRefId=" + carRefId +
				", brand='" + brand + '\'' +
				", model='" + model + '\'' +
				", averagePrice=" + averagePrice +
				", yearMade=" + yearMade +
				", noOfCarsSold=" + noOfCarsSold +
				'}';
	}
}