package com.mongo.ctlr;

import com.mongo.entity.Car;
import com.mongo.entity.Customer;
import com.mongo.gutil.SequenceGenerator;
import com.mongo.repo.Repositories;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@ComponentScan("com.mongo.repo")

@RequestMapping("/car")
public class SprController {
    protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    Repositories repositories;

    @GetMapping("/lisCars")
    public List<Car> getAllCars() {

        return( repositories.findAllCars() ) ;
    }

    @GetMapping("/liscustomer")
    public List<Customer> getAllCustomer() {

        return( repositories.findAllCustomers() ) ;
    }
    //
    @PutMapping("/updCar")
    public Car updCar(@RequestBody Car carToUpd) {
        logger.info("UpdCar Started " + carToUpd.toString() );

        repositories.updCar(carToUpd);
        logger.info("UpdCar Done " + carToUpd.toString() );
        return carToUpd ;
    }
    @PostMapping("/addCar")
    public Car addCar(@RequestBody Car newCar) {
        logger.info("addCar Started " + newCar.toString() );
        SequenceGenerator sequenceGenerator = new SequenceGenerator();
        newCar.setCarRefId(sequenceGenerator.nextIdStr());
        repositories.create(newCar);
        logger.info("addCar Done " + newCar.toString() );
        return newCar ;
    }
    //
    @DeleteMapping("/deleteCar/{carRefId}")   ///{ownerId}
    public void deleteCar(@PathVariable String carRefId) {
        logger.info("deleteCar  Started carRefId=" + carRefId );
        repositories.deleteCar(carRefId);
        logger.info("carToDelete Done carRefId=" + carRefId );

    }



}