package com.mongo.repo;

import com.mongo.cfg.ConfigMongoDB1;
import com.mongo.cfg.ConfigMongoDB2;
import com.mongo.entity.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
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
    ConfigMongoDB2 configMongoDB;

    @Autowired
    @Qualifier("BTemplate2")
    public MongoTemplate getMongoTemplate2() {
        return this.configMongoDB.getMongoTemplate2();
    }
    public void dropCars2() {
        this.configMongoDB.getMongoTemplate2().dropCollection(CAR_COLLECTION2);
    }

    public void saveAllCars2(List<Car2> lisOfCars) {
        this.configMongoDB.getMongoTemplate2().insert(lisOfCars, Car2.class);
    }
    public List<Car2> findAllCars2() {
        return (this.configMongoDB.getMongoTemplate2().findAll(Car2.class));
    }
}