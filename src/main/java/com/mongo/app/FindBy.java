package com.mongo.app;
import com.mongo.entity.Car;
import com.mongo.entity.Customer;
import com.mongo.entity.CustomerCarDb;
import com.mongo.repo.Repositories1;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;
public class FindBy implements DoRunIFWithRepo<Repositories1> {
    protected final Log logger = LogFactory.getLog(getClass());
    protected Repositories1 repositoriesi ;
    @Override
    public void doRun1(Repositories1 repositories) {
        repositoriesi = repositories ;
        //try1
       List<CustomerCarDb> lis2 = tryx1("name-10");
       lis2.forEach(l2-> logger.info(l2) ) ;

        logger.info("***************** FindBy started") ;
        List<Customer> cusLis = repositories.findCustomerByName("name-8");
        cusLis.forEach(cus-> logger.info(cus) ) ;
        List<Car> carLis = repositories.findCarBycarRefId(Long.valueOf("697950862765211648"));
        carLis.forEach(car-> logger.info(car) ) ;
        logger.info("***************** FindBy end") ;
//  Spring Mongo https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#preface
//  https://riptutorial.com/mongodb/example/24559/java-and-spring-example
// write Own in Spring https://www.sgmoratilla.com/2019-05-23-mixing-spring-data-mongo-queries/
        //Equivalent to $group
//        DBObject groupFields = new BasicDBObject("_id", "$dept");
//        groupFields.put("ageSet", new BasicDBObject("$addToSet", "$age"));
//        DBObject employeeDocProjection = new BasicDBObject("$addToSet", new BasicDBObject("totalExp", "$totalExp").append("age", "$age").append("languages", "$languages").append("dept", "$dept").append("name", "$name"));
//        groupFields.put("docs", employeeDocProjection);
//        DBObject group = new BasicDBObject("$group", groupFields);
    }

    public List<CustomerCarDb> tryx1(String cusName)  {
//
//        LookupOperation lookup = LookupOperation.newLookup().from("cars")
//                .localField("refToCars").foreignField("carRefId")  //refToCars should be as Mongo field name in prime collection
//                //the local/prime collection is customers. Here local refToCars is a list in customers
//                .as("carsDbResult");        // should be cars foreign collection where cars is the field/bean in CustomerCarDb class
//        MatchOperation matchOperStage1 = Aggregation.match(Criteria.where("name").is(cusName)) ;
//        //ProjectionOperation projectAggregation = project("name", "cusId", "lisOfCarInfo.carMileage","$cars.model");
//        // Aggregation aggregation = Aggregation.newAggregation(matchStage, projectAggregation,lookup);
//        Aggregation aggregation = Aggregation.newAggregation(matchOperStage1, lookup);
//        List<CustomerCarDb> results1 = this.repositoriesi.getMongoTemplate().aggregate(aggregation, "customers", CustomerCarDb.class).getMappedResults();
        //
        LookupOperation lookupStage = LookupOperation.newLookup().from("cars")
                .localField("refToCars").foreignField("carRefId")  //refToCars should be as Mongo field name in prime collection
                //the local/prime collection is customers. Here local refToCars is a list in customers
                .as("carsDbResult");        // should be cars foreign collection where cars is the field/bean in CustomerCarDb class
        MatchOperation matchOperStage = Aggregation.match(Criteria.where("name").is(cusName)) ;
        AggregationOperation replaceRootStage = Aggregation.replaceRoot().withValueOf(ObjectOperators.valueOf("carsDbResult").mergeWith(Aggregation.ROOT));
        AggregationOperation project = Aggregation.project(Car.class).andInclude("carRefId","model","brand").andExclude("averagePrice") ;
        AggregationOperation unwind = Aggregation.unwind("carsDbResult");
        Aggregation pipeLineAggregation = Aggregation.newAggregation(lookupStage,matchOperStage) ;
        // Aggregation aggregation = Aggregation.newAggregation(lookup,  replaceRoot, project, out);
        List<CustomerCarDb> results = this.repositoriesi.getMongoTemplate().aggregate(pipeLineAggregation, "customers", CustomerCarDb.class).getMappedResults();
        return results ;
    }
}
