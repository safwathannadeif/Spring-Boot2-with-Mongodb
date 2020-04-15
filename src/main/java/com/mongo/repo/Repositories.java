package com.mongo.repo;
import com.mongo.cfg.ConfigMongoDB;
import com.mongo.entity.Car;
import com.mongo.entity.CarSaleTotal;
import com.mongo.entity.Customer;
import com.mongo.entity.CustomerCarDb;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.query.Criteria.where;
@Repository
@ComponentScan("com.mongo.cfg")
public class Repositories {
    private static final String CAR_COLLECTION = "cars";
    private static final String CUS_COLLECTION = "customers";
    //
        @Autowired
        ConfigMongoDB configMongoDB;
    public MongoTemplate getMongoTemplate() {
        return this.configMongoDB.getMongoTemplate() ;
    }
    public void saveAllCars(List<Car> lisOfCars) {
        this.configMongoDB.getMongoTemplate().insert(lisOfCars,Car.class);
    }
 //
        public void saveAllCustomers(List<Customer> lisOfCus) {
            this.configMongoDB.getMongoTemplate().insert(lisOfCus,Customer.class);
        }
//
    public List<CustomerCarDb> lookupCusCarByCustomerName(String cusName) {
        LookupOperation lookup = LookupOperation.newLookup().from("cars")
                .localField("refToCars").foreignField("carRefId")  //refToCars should be as Mongo field name in prime collection
                                                                         //the local/prime collection is customers. Here local refToCars is a list in customers
                 .as("carsDbResult");        // should be cars foreign collection where cars is the field/bean in CustomerCarDb class
        MatchOperation matchOperStage = Aggregation.match(Criteria.where("name").is(cusName)) ;
     //ProjectionOperation projectAggregation = project("name", "cusId", "lisOfCarInfo.carMileage","$cars.model");
     // Aggregation aggregation = Aggregation.newAggregation(matchStage, projectAggregation,lookup);
        Aggregation aggregation = Aggregation.newAggregation(matchOperStage, lookup);
        List<CustomerCarDb> results = this.configMongoDB.getMongoTemplate().aggregate(aggregation, "customers", CustomerCarDb.class).getMappedResults();
        return results ;
    }
//
// nested Objechttps://stackoverflow.com/questions/12730370/spring-data-mongodb-findby-method-for-nested-objects
public List<CustomerCarDb> lookupCusCarByCustomerNameList(List<String> cusNameLis) {
    LookupOperation lookup = LookupOperation.newLookup().from("cars")
            .localField("refToCars").foreignField("carRefId")  //refToCars should be as Mongo field name in prime collection
            //the local/prime collection is customers. Here local refToCars is a list in customers
            .as("carsDbResult");        // should be cars foreign collection where cars is the field/bean in CustomerCarDb class
    MatchOperation matchOperStage = Aggregation.match(Criteria.where("name").in(cusNameLis)) ;
    //ProjectionOperation projectAggregation = project("name", "cusId", "lisOfCarInfo.carMileage","$cars.model");
    // Aggregation aggregation = Aggregation.newAggregation(matchStage, projectAggregation,lookup);
   AggregationOperation project = Aggregation.project().andExclude("carsDbResult.$averagePrice") ; //averagePrice
    Aggregation aggregation = Aggregation.newAggregation(matchOperStage, lookup,project);
    List<CustomerCarDb> results = this.configMongoDB.getMongoTemplate().aggregate(aggregation, "customers", CustomerCarDb.class).getMappedResults();
    return results ;
}
    public List<Customer> findAllCustomers() {
        return( this.configMongoDB.getMongoTemplate().findAll(Customer.class) );
    }
        public List<Car> findAllCars() {
           return( this.configMongoDB.getMongoTemplate().findAll(Car.class) );
        }
        public void create(Car car) {
            if (car != null) {
                this.configMongoDB.getMongoTemplate().insert(car, CAR_COLLECTION);
            }
        }
    public  List<Customer>   findCustomerByName(String nameInp) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(nameInp)) ;
        return(this.configMongoDB.getMongoTemplate().find(query,Customer.class)) ;
    }
    public  List<Car>   findCarBycarRefId(Long refId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("carRefId").is(refId)) ;
        return(this.configMongoDB.getMongoTemplate().find(query,Car.class)) ;
    }
    public void dropCustomers() {
        this.configMongoDB.getMongoTemplate().dropCollection(CUS_COLLECTION);
    }
    public void dropCars() {
            this.configMongoDB.getMongoTemplate().dropCollection(CAR_COLLECTION);
        }

    public List<CarSaleTotal> aggregationByBrandUsedIn(String... inLis) {
        Aggregation aggregation = newAggregation(
                project("averagePrice","noOfCarsSold","brand", "yearMade","model").andExpression("averagePrice * noOfCarsSold").as("totalPerBrand") ,
                match(where("brand").in(inLis)),
                // group("brand", "yearMade").sum("averagePrice").as("total"),
                sort(Sort.Direction.ASC,  "brand")
        );

       return( configMongoDB.getMongoTemplate().aggregate(aggregation, "cars", CarSaleTotal.class).getMappedResults() ) ;
    }


        public List<CarSaleTotal> aggregationByAll() {
            Aggregation aggregation = newAggregation(
            project("averagePrice","noOfCarsSold","brand", "yearMade","model").andExpression("averagePrice * noOfCarsSold").as("totalPerBrand") ,
            //group("brand","yearMade").sum("totalPerBrand").as("allTotal") , /* Here to get allTotal but without other fields */
            sort(Sort.Direction.DESC, "brand", "model")
            );
            AggregationResults<CarSaleTotal> groupResults = configMongoDB.getMongoTemplate().aggregate(
                    aggregation, "cars", CarSaleTotal.class);
            List<CarSaleTotal> salesAll = groupResults.getMappedResults();
            return salesAll;
        }
        public List<CarSaleTotal> aggregationByYear(int year) {
            Aggregation aggregation = newAggregation(
                    project("averagePrice","noOfCarsSold","brand", "yearMade","model").andExpression("averagePrice * noOfCarsSold").as("totalPerBrand") ,
                    match(where("yearMade").is(year)),
                   // group("brand", "yearMade").sum("averagePrice").as("total"),
                    sort(Sort.Direction.ASC,  "brand")
            );
            AggregationResults<CarSaleTotal> groupResults = configMongoDB.getMongoTemplate().aggregate(
                    aggregation, "cars", CarSaleTotal.class);
            List<CarSaleTotal> salesPerYear = groupResults.getMappedResults();
            return salesPerYear;
        }
        public List<CustomerCarDb> try1(String cusName)  {

            LookupOperation lookupStage = LookupOperation.newLookup().from("cars")
                    .localField("refToCars").foreignField("carRefId")  //refToCars should be as Mongo field name in prime collection
                    //the local/prime collection is customers. Here local refToCars is a list in customers
                    .as("carArrayForeignObject");        // should be cars foreign collection where cars is the field/bean in CustomerCarDb class
            MatchOperation matchOperStage = Aggregation.match(Criteria.where("name").is(cusName)) ;
            AggregationOperation replaceRootStage = Aggregation.replaceRoot().withValueOf(ObjectOperators.valueOf("carArrayForeignObject").mergeWith(Aggregation.ROOT));
            AggregationOperation project = Aggregation.project().andExclude("id", "carArrayForeignObject");
            Aggregation pipeLineAggregation = Aggregation.newAggregation(matchOperStage, lookupStage,project);
           // Aggregation aggregation = Aggregation.newAggregation(lookup,  replaceRoot, project, out);
            List<CustomerCarDb> results = this.configMongoDB.getMongoTemplate().aggregate(pipeLineAggregation, "customers", CustomerCarDb.class).getMappedResults();
            return results ;
        }
}
