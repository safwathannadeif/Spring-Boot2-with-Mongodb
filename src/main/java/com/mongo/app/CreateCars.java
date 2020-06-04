package com.mongo.app;
import com.mongo.entity.Car;
import com.mongo.gutil.SequenceGenerator;
import com.mongo.repo.Repositories1;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
public class CreateCars implements DoRunIFWithRepo<Repositories1> {
    protected final Log logger = LogFactory.getLog(getClass());
    @Override
    public void doRun1(Repositories1 repositories) {
        repositories.dropCars();
        List<Car>  lisOfCars= new ArrayList<>() ;
        SequenceGenerator sequenceGenerator = new SequenceGenerator();
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Jaguar", "K-Jaguar", 30000, 2020,200) );
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Volvo", "Truck-Volvo", 21000, 2020,250)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mercedes-Benz", "HighEnd", 26000, 2020,400)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mitsubishi", "J-Mitsubishi", 25000, 2020,700)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Volkswagen", "Polo", 12000, 2020,1000)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Tesla", "Tesla-S", 65000, 2020,120)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Honda", "Acura", 24000, 2020,589)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Dodge", "D-734", 17000, 2020,6000)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "BMW", "i3-A", 47000, 2020,2200)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Toyota", "Prius", 29000, 2020,175)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Hyundai", "i22-A", 21000, 2020,1000)) ;

        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Jaguar", "K-Jaguar", 29000, 2019,100)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Volvo", "Truck-Volvo", 20000, 2019,200)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mercedes-Benz", "HighEnd", 25000, 2019,400)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mitsubishi", "J-Mitsubishi", 22000, 2019,700)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Volkswagen", "Polo", 11000, 2019,1000)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Tesla", "Tesla-S", 61000, 2019,600)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Honda", "Acura", 22000, 2019,90)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Dodge", "D-734", 15000, 2019,500)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "BMW", "i3-A", 45000, 2019,70)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Toyota", "Prius", 27000, 2019,1100)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Hyundai", "i22-A", 19000, 2019,2000)) ;


        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Jaguar", "K-Jaguar", 29000, 2018,100)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Volvo", "Truck-Volvo", 20000, 2018,200)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mercedes-Benz", "HighEnd", 25000, 2018,400)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mitsubishi", "J-Mitsubishi", 22000, 2018,700)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Volkswagen", "Polo", 11000, 2018,1000)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Tesla", "Tesla-S", 61000, 2018,600)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Honda", "Acura", 22000, 2018,90)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Dodge", "D-734", 15000, 2018,500)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "BMW", "i3-A", 45000, 2018,70)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Toyota", "Prius", 27000, 2018,1100)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Hyundai", "i22-A", 19000, 2018,2000)) ;

        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Jaguar", "K-Jaguar", 29000, 2017,100)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Volvo", "Truck-Volvo", 20000, 2017,200)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mercedes-Benz", "HighEnd", 25000, 2017,400)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mitsubishi", "J-Mitsubishi", 22000, 2017,700)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Volkswagen", "Polo", 11000, 2017,1000)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Tesla", "Tesla-S", 61000, 2017,600)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Honda", "Acura", 22000, 2017,90)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Dodge", "D-734", 15000, 2017,500)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "BMW", "i3-A", 45000, 2017,70)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Toyota", "Prius", 27000, 2017,1100)) ;
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Hyundai", "i22-A", 19000, 2017,2000)) ;
        repositories.saveAllCars(lisOfCars);
    }
}

