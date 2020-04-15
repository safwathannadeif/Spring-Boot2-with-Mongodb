package com.mongo.entity;
import org.springframework.data.mongodb.core.mapping.Document;
/*
private String brand;
	private String model;
	private int averagePrice;
	private int yearMade;
	private int noOfCarsSold ;
	totalPerBrand
 */
@Document(collection = "carcaletotal")
public class CarSaleTotal {
	private String brand;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	private String model;
	private int averagePrice;
	private long totalPerBrand ;
	private int yearMade;
	private int noOfCarsSold ;
	private Long allTotal ;
	public CarSaleTotal() {
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(int averagePrice) {
		this.averagePrice = averagePrice;
	}
	public long getTotalPerBrand() {
		return totalPerBrand;
	}
	public void setTotalPerBrand(long totalPerBrand) {
		this.totalPerBrand = totalPerBrand;
	}
	public int getYearMade() {
		return yearMade;
	}
	public void setYearMade(int yearMade) {
		this.yearMade = yearMade;
	}
	public int getNoOfCarsSold() {
		return noOfCarsSold;
	}
	public void setNoOfCarsSold(int noOfCarsSold) {
		this.noOfCarsSold = noOfCarsSold;
	}
	public Long getAllTotal() {
		return allTotal;
	}
	public void setAllTotal(Long allTotal) {
		this.allTotal = allTotal;
	}

	@Override
	public String toString() {
		return "CarSaleTotal{" +
				"brand='" + brand + '\'' +
				",model='" + model + '\'' +
				", yearMade=" + yearMade +
				", averagePrice=" + averagePrice +
				", noOfCarsSold=" + noOfCarsSold +
				", totalPerBrand=" + totalPerBrand +         //Calculted by Spring as new field using andExpression
			//	", allTotal=" + allTotal +  // Only for when group by //
				'}';
	}
}