package com.mongo.ctlr;

import com.mongo.entity.Car;
import com.mongo.entity.Car2;
import com.mongo.repo.Repositories1;
import com.mongo.repo.Repositories2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;
    @RestController
    @ComponentScan("com.mongo.repo")

    @RequestMapping("/car2")
    public class SprController2 {
        protected final Log logger = LogFactory.getLog(getClass());
        @Autowired
        @Qualifier("Repo2")
        Repositories2 repositories2 ;
        @GetMapping("/lisCars2")
        public List<Car2> getAllCars2() {

            return( repositories2.findAllCars2() ) ;
        }
        @PutMapping("/updCar2")
        public Car2 updCar2(@RequestBody Car2 carToUpd) {
            logger.info("UpdCar Started " + carToUpd.toString() );

            Car2 updtedCar2 = repositories2.updCar2(carToUpd);
            logger.info("UpdCar Done " + updtedCar2.toString() );
            return updtedCar2 ;
        }

}
