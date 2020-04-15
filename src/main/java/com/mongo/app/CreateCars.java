package com.mongo.app;
import com.mongo.entity.Car;
import com.mongo.gutil.SequenceGenerator;
import com.mongo.repo.Repositories;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
public class CreateCars implements DoRunIF {
    protected final Log logger = LogFactory.getLog(getClass());
    @Override
    public void doRun(Repositories repositories) {
        repositories.dropCars();
        List<Car>  lisOfCars= new ArrayList<>() ;
        SequenceGenerator sequenceGenerator = new SequenceGenerator();
       //
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "Jaguar", "K-Jaguar", 29000, 2017,100)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "Volvo", "Truck-Volvo", 20000, 2017,200)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "Mercedes-Benz", "HighEnd", 25000, 2017,400)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "Mitsubishi", "J-Mitsubishi", 22000, 2017,700)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "Volkswagen", "Polo", 11000, 2017,1000)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "Tesla", "Tesla-S", 61000, 2017,600)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "Honda", "Acura", 22000, 2017,90)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "Dodge", "D-734", 15000, 2017,500)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "BMW", "i3-A", 45000, 2017,70)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "Toyota", "Prius", 27000, 2017,1100)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "Hyundai", "i22-A", 19000, 2017,2000)) ;
       //
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "Jaguar", "K-Jaguar", 30000, 2020,200) );
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "Volvo", "Truck-Volvo", 21000, 2020,250)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "Mercedes-Benz", "HighEnd", 26000, 2020,400)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "Mitsubishi", "J-Mitsubishi", 25000, 2020,700)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "Volkswagen", "Polo", 12000, 2020,1000)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "Tesla", "Tesla-S", 65000, 2020,120)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "Honda", "Acura", 24000, 2020,589)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "Dodge", "D-734", 17000, 2020,6000)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "BMW", "i3-A", 47000, 2020,2200)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "Toyota", "Prius", 29000, 2020,175)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextId(), "Hyundai", "i22-A", 21000, 2020,1000)) ;
        repositories.saveAllCars(lisOfCars);
    }
}

