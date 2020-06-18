package com.mongo.repo;

import com.mongo.cfg.ConfigMongoDB1;
import com.mongo.cfg.ConfigMongoDB2;
import com.mongo.entity.*;
import com.mongodb.client.result.UpdateResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository ("Repo2")
@ComponentScan("com.mongo.cfg")

public class Repositories2 {
    private static final String CAR_COLLECTION2 = "cars2";
    private static final String CUS_COLLECTION2 = "customers2";


    protected final Log logger = LogFactory.getLog(getClass());
    //
    @Autowired
    @Qualifier("Config2")
    ConfigMongoDB2 configMongoDB2;

    @Autowired
    @Qualifier("BTemplate2")
    public MongoTemplate getMongoTemplate2() {
        return this.configMongoDB2.getMongoTemplate2();
    }
    public void dropCars2() {
        this.configMongoDB2.getMongoTemplate2().dropCollection(CAR_COLLECTION2);
    }

    public void saveAllCars2(List<Car2> lisOfCars) {
        this.configMongoDB2.getMongoTemplate2().insert(lisOfCars, Car2.class);
    }
    public List<Car2> findAllCars2() {
        return (this.configMongoDB2.getMongoTemplate2().findAll(Car2.class));
    }

    public Car2 updCar2(Car2 car2) {
       Query query = new Query();  //carRefId: Uni Index
       query.addCriteria(Criteria.where("carRefId").is(car2.getCarRefId())); // carRefId is unique index
       Update update = new Update();
       update.set("lisByColor", car2.getLisByColor()) ;
       UpdateResult updateResult = this.configMongoDB2.getMongoTemplate2().updateFirst(query, update, Car2.class);
       // Car2 car2Updted =  this.configMongoDB2.getMongoTemplate2().save(car2) ;
       logger.info("cari.getCarRefId() inp :"+ car2.getCarRefId() ); ;
       logger.info("UpdateResult Matced Count=" + updateResult.getMatchedCount());
       //logger.info("Updated Car2=" + car2Updted.toString() ) ;
       logger.info("cari.getCarRefId() inp :"+ car2.getCarRefId() ); ;
       //logger.info("foundCar afterUpd:"+ foundCar.toString()); ;
    return car2 ;
    }
}