package com.mongo.repo;
import com.mongo.cfg.ConfigMongoDB1;
import com.mongo.entity.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.query.Criteria.where;
@Repository
@ComponentScan("com.mongo.cfg")
public class Repositories1 {
    private static final String CAR_COLLECTION = "cars";
    private static final String CUS_COLLECTION = "customers";

    private static final String CAR_COLLECTION2 = "cars2";
    private static final String CUS_COLLECTION2 = "customers2";

    protected final Log logger = LogFactory.getLog(getClass());
    //
    @Autowired
    ConfigMongoDB1 configMongoDB;

    public MongoTemplate getMongoTemplate() {
        return this.configMongoDB.getMongoTemplate();
    }

    public void saveAllCars(List<Car> lisOfCars) {
        this.configMongoDB.getMongoTemplate().insert(lisOfCars, Car.class);
    }
    //
    public enum FindCusByCases { FindByCusName , FindByCusid} ;

    public void saveAllCustomers(List<Customer> lisOfCus) {
        this.configMongoDB.getMongoTemplate().insert(lisOfCus, Customer.class);
    }
    public void saveAllCars2(List<Car2> lisOfCars) {
        this.configMongoDB.getMongoTemplate().insert(lisOfCars, Car2.class);
    }
    //
    public List<CustomerCarDb> lookupCusCarByCustomerName(String cusNameOrCusId,FindCusByCases enuCase ) {
        LookupOperation lookup = LookupOperation.newLookup().from("cars")
                .localField("refToCars").foreignField("carRefId")  //refToCars should be as Mongo field name in prime collection
                //the local/prime collection is customers. Here local refToCars is a list in customers
                .as("carsDbResult");        // should be cars foreign collection where cars is the field/bean in CustomerCarDb class
        MatchOperation matchOperStage =null ;
        switch(enuCase)
        {
            case FindByCusName:
                matchOperStage = Aggregation.match(Criteria.where("name").is(cusNameOrCusId.trim()));
                break ;
            case FindByCusid:
                matchOperStage = Aggregation.match(Criteria.where("cusId").is(cusNameOrCusId.trim()));
        }
       // MatchOperation matchOperStage = Aggregation.match(Criteria.where("name").is(cusName));
        //ProjectionOperation projectAggregation = project("name", "cusId", "lisOfCarInfo.carMileage","$cars.model");
        // Aggregation aggregation = Aggregation.newAggregation(matchStage, projectAggregation,lookup);
        Aggregation aggregation = Aggregation.newAggregation(matchOperStage, lookup);
        List<CustomerCarDb> results = this.configMongoDB.getMongoTemplate().aggregate(aggregation, "customers", CustomerCarDb.class).getMappedResults();
        return results;
    }

    //
// nested Objechttps://stackoverflow.com/questions/12730370/spring-data-mongodb-findby-method-for-nested-objects
    public List<CustomerCarDb> lookupCusCarByCustomerNameList(List<String> cusNameLis) {
        LookupOperation lookup = LookupOperation.newLookup().from("cars")
                .localField("refToCars").foreignField("carRefId")  //refToCars should be as Mongo field name in prime collection
                //the local/prime collection is customers. Here local refToCars is a list in customers
                .as("carsDbResult");        // should be cars foreign collection where cars is the field/bean in CustomerCarDb class
        MatchOperation matchOperStage = Aggregation.match(Criteria.where("name").in(cusNameLis));
        //ProjectionOperation projectAggregation = project("name", "cusId", "lisOfCarInfo.carMileage","$cars.model");
        // Aggregation aggregation = Aggregation.newAggregation(matchStage, projectAggregation,lookup);
        AggregationOperation project = Aggregation.project().andExclude("carsDbResult.$averagePrice"); //averagePrice
        Aggregation aggregation = Aggregation.newAggregation(matchOperStage, lookup, project);
        List<CustomerCarDb> results = this.configMongoDB.getMongoTemplate().aggregate(aggregation, "customers", CustomerCarDb.class).getMappedResults();
        return results;
    }

    public List<Customer> findAllCustomers() {
        return (this.configMongoDB.getMongoTemplate().findAll(Customer.class));
    }

    public List<Car> findAllCars() {
        return (this.configMongoDB.getMongoTemplate().findAll(Car.class));
    }

    public void create(Car car) {
        if (car != null) {
            this.configMongoDB.getMongoTemplate().insert(car, CAR_COLLECTION);
        }
    }

    public List<Customer> findCustomerByName(String nameInp) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(nameInp));
        return (this.configMongoDB.getMongoTemplate().find(query, Customer.class));
    }

    public List<Car> findCarBycarRefId(Long refId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("carRefId").is(refId));
        return (this.configMongoDB.getMongoTemplate().find(query, Car.class));
    }

    public void dropCustomers() {
        this.configMongoDB.getMongoTemplate().dropCollection(CUS_COLLECTION);
    }

    public void dropCars() {
        this.configMongoDB.getMongoTemplate().dropCollection(CAR_COLLECTION);
    }

    public List<CarSaleTotal> aggregationByBrandUsedIn(String... inLis) {
        Aggregation aggregation = newAggregation(
                project("averagePrice", "noOfCarsSold", "brand", "yearMade", "model").andExpression("averagePrice * noOfCarsSold").as("totalPerBrand"),
                match(where("brand").in(inLis)),
                // group("brand", "yearMade").sum("averagePrice").as("total"),
                sort(Sort.Direction.ASC, "brand")
        );

        return (configMongoDB.getMongoTemplate().aggregate(aggregation, "cars", CarSaleTotal.class).getMappedResults());
    }


    public List<CarSaleTotal> aggregationByAll() {
        Aggregation aggregation = newAggregation(
                project("averagePrice", "noOfCarsSold", "brand", "yearMade", "model").andExpression("averagePrice * noOfCarsSold").as("totalPerBrand"),
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
                project("averagePrice", "noOfCarsSold", "brand", "yearMade", "model").andExpression("averagePrice * noOfCarsSold").as("totalPerBrand"),
                match(where("yearMade").is(year)),
                // group("brand", "yearMade").sum("averagePrice").as("total"),
                sort(Sort.Direction.ASC, "brand")
        );
        AggregationResults<CarSaleTotal> groupResults = configMongoDB.getMongoTemplate().aggregate(
                aggregation, "cars", CarSaleTotal.class);
        List<CarSaleTotal> salesPerYear = groupResults.getMappedResults();
        return salesPerYear;
    }

    public List<CustomerCarDb> try1(String cusName) {

        LookupOperation lookupStage = LookupOperation.newLookup().from("cars")
                .localField("refToCars").foreignField("carRefId")  //refToCars should be as Mongo field name in prime collection
                //the local/prime collection is customers. Here local refToCars is a list in customers
                .as("carArrayForeignObject");        // should be cars foreign collection where cars is the field/bean in CustomerCarDb class
        MatchOperation matchOperStage = Aggregation.match(Criteria.where("name").is(cusName));
        AggregationOperation replaceRootStage = Aggregation.replaceRoot().withValueOf(ObjectOperators.valueOf("carArrayForeignObject").mergeWith(Aggregation.ROOT));
        AggregationOperation project = Aggregation.project().andExclude("id", "carArrayForeignObject");
        Aggregation pipeLineAggregation = Aggregation.newAggregation(matchOperStage, lookupStage, project);
        // Aggregation aggregation = Aggregation.newAggregation(lookup,  replaceRoot, project, out);
        List<CustomerCarDb> results = this.configMongoDB.getMongoTemplate().aggregate(pipeLineAggregation, "customers", CustomerCarDb.class).getMappedResults();
        return results;
    }
    //
    public void deleteCar(String carRefId) {
        Query query = new Query();  //carRefId: Uni Index
        query.addCriteria(Criteria.where("carRefId").is(carRefId.trim())); // carRefId is unique index
        query.fields().include("carRefId");
        DeleteResult dresult =this.configMongoDB.getMongoTemplate().remove(query, Car.class);
        logger.info("DeleteResult Deleted Count =" + dresult.getDeletedCount()) ;
    }

    public void updCar(Car cari) {
        //
        Query query = new Query();  //carRefId: Uni Index
//        query.addCriteria(Criteria.where("brand").is(cari.getBrand())); // carRefId is unique index
//        query.addCriteria(Criteria.where("model").is(cari.getModel())); // carRefId is unique index
//        query.addCriteria(Criteria.where("yearMade").is(cari.getYearMade())); // carRefId is unique index
        query.addCriteria(Criteria.where("carRefId").is(cari.getCarRefId())); // carRefId is unique index
        query.fields().include("carRefId");
        Update update = new Update();
        update.set("averagePrice", cari.getAveragePrice()).set("noOfCarsSold", cari.getNoOfCarsSold());
        UpdateResult updateResult = this.configMongoDB.getMongoTemplate().updateFirst(query, update, Car.class);
        logger.info("UpdateResult Matced Count=" + updateResult.getMatchedCount());
        //
        //Car foundCar = this.configMongoDB.getMongoTemplate().findOne(query, Car.class); //findAndModify
        //
        logger.info("cari.getCarRefId() inp :"+ cari.getCarRefId() ); ;
        //logger.info("foundCar afterUpd:"+ foundCar.toString()); ;

    }
}
