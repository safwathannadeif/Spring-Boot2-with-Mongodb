package com.mongo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer2cars")
public class Customer2CarDB {
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

    //private String insuranceFields ;  // ??


    public Customer2CarDB() {
    }
    public Customer2CarDB(String[] stry,String cusIdi) {

     firstName=stry[1] ;                // inp id -- 1
     lastName=stry[2];                  //  inp id -- 2
     email=stry[3] ;                    //  inp id -- 3
     street=stry[5]  ;                  //  inp id -- 5
     postal=stry[6] ;                   //  inp id -- 6
     city=stry[7] ;                     //  inp id -- 7
     phone=stry[8] ;                    //  inp id -- 8
     states=stry[9]    ;                //  inp id -- 9
     String insuranceFields= stry[10] ;
     extractInsurancefields(insuranceFields) ;
     customerId= cusIdi ;
   //  insuranceCompany=stry[10]   ;      // inp  id--10
   //  insurancePolicyNum=stry[11] ;      // inp  id--11
    }
    private void extractInsurancefields(String insFlds) {
      String[] str2Flds= insFlds.replace("\"","") .split(",") ;

        if (str2Flds.length == 3) {
            insuranceCompany = str2Flds[0].trim() + str2Flds[1].trim() ;
            insurancePolicyNum = str2Flds[2].trim() ;
        }
        if (str2Flds.length == 2) {
            insuranceCompany = str2Flds[0].trim() ;
            insurancePolicyNum = str2Flds[1].trim() ;
        }
        if (str2Flds.length != 2 && str2Flds.length !=3) throw new RuntimeException("incorrect Input Fields for Insurance ")  ;

        StringBuilder sb = new StringBuilder(postal);
        insurancePolicyNum = insurancePolicyNum +"-" + sb.reverse().toString()+ phone.substring(2,11);

    }

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

    @Override
    public String toString() {
        return "Customer2CarDB{" +
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
                '}';
    }
}
