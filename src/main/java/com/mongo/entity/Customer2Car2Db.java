package com.mongo.entity;
import java.util.ArrayList;
import java.util.List;
public class Customer2Car2Db {
    private String customerId ;
    private String firstName ;             // inp id -- 1
    private String lastName ;              //  inp id -- 2
    private String email ;                  //  inp id -- 3
    private String street ;                 //  inp id -- 5
    private String postal ;                 //  inp id -- 6
    private String city ;                   //  inp id -- 7
    private String phone ;                  //  inp id -- 8
    private String states ;                 //  inp id -- 9
    private String insuranceCompany ;       // inp  id--10
    private String insurancePolicyNum ;      // inp  id--11\
    private String driveLicense  ;
    private List<CarCusInfo2>      lisOfCarsInfo = new ArrayList<>();
    private List<Car2> cars2DbResult ;  //Should be the as in lookup parm # 4
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getPostal() {
        return postal;
    }
    public void setPostal(String postal) {
        this.postal = postal;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getStates() {
        return states;
    }
    public void setStates(String states) {
        this.states = states;
    }
    public String getInsuranceCompany() {
        return insuranceCompany;
    }
    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }
    public String getInsurancePolicyNum() {
        return insurancePolicyNum;
    }
    public void setInsurancePolicyNum(String insurancePolicyNum) {
        this.insurancePolicyNum = insurancePolicyNum;
    }
    public String getDriveLicense() {
        return driveLicense;
    }
    public void setDriveLicense(String driveLicense) {
        this.driveLicense = driveLicense;
    }
    public List<CarCusInfo2> getLisOfCarSInfo() {
        return lisOfCarsInfo;
    }
    public void setLisOfCarSInfo(List<CarCusInfo2> lisOfCarSInfo) {
        this.lisOfCarsInfo = lisOfCarSInfo;
    }
    public List<Car2> getCars2DbResult() {
        return cars2DbResult;
    }
    public void setCars2DbResult(List<Car2> cars2DbResult) {
        this.cars2DbResult = cars2DbResult;
    }
    @Override
    public String toString() {
        return "Customer2Car2Db{" +
                "customerId='" + customerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", street='" + street + '\'' +
                ", postal='" + postal + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", states='" + states + '\'' +
                ", insuranceCompany='" + insuranceCompany + '\'' +
                ", insurancePolicyNum='" + insurancePolicyNum + '\'' +
                ", driveLicense='" + driveLicense + '\'' +
                ", lisOfCarSInfo=" + lisOfCarsInfo +
                ", cars2DbResult=" + cars2DbResult +
                '}';
    }
}
