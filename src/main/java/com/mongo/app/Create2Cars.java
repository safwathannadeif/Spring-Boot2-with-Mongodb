package com.mongo.app;

import com.mongo.entity.Car;
import com.mongo.entity.Car2;
import com.mongo.entity.Car2Entry;
import com.mongo.gutil.ColorName;
import com.mongo.gutil.SequenceGenerator;
import com.mongo.repo.Repositories2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Create2Cars implements DoRunIFWithRepo<Repositories2> {
    protected final Log logger = LogFactory.getLog(getClass());
    protected int noOfCarEntries = 0;
    protected int colorInx = -1;
    protected final int minNoOfCarEntries = 2;
    protected final int maxNoOfCarEntries = 11;
    protected List<Car2> lisOfCars2 = new ArrayList<>();


    @Override
    public void doRun1(Repositories2 repositories) {
        // repositories.dropCars();
        List<Car> lisOfCars = new ArrayList<>();
        SequenceGenerator sequenceGenerator = new SequenceGenerator();
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Audi", "Q3", 38000, 2020, 20));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Audi", "A8", 37000, 2020, 17));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Jaguar", "K-Jaguar", 30000, 2020, 200));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Volvo", "Truck-Volvo", 21000, 2020, 250));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mercedes-Benz", "HighEnd", 26000, 2020, 400));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mitsubishi", "J-Mitsubishi", 25000, 2020, 700));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Volkswagen", "Polo", 12000, 2020, 1000));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Tesla", "Tesla-S", 65000, 2020, 120));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Honda", "Acura", 24000, 2020, 589));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Dodge", "D-734", 17000, 2020, 6000));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "BMW", "i3-A", 47000, 2020, 2200));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Toyota", "Prius", 29000, 2020, 175));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Hyundai", "i22-A", 21000, 2020, 1000));

        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Audi", "Q3", 37000, 2019, 21));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Audi", "A8", 35000, 2019, 19));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Jaguar", "K-Jaguar", 29000, 2019, 100));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Volvo", "Truck-Volvo", 20000, 2019, 200));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mercedes-Benz", "HighEnd", 25000, 2019, 400));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mitsubishi", "J-Mitsubishi", 22000, 2019, 700));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Volkswagen", "Polo", 11000, 2019, 1000));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Tesla", "Tesla-S", 61000, 2019, 600));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Honda", "Acura", 22000, 2019, 90));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Dodge", "D-734", 15000, 2019, 500));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "BMW", "i3-A", 45000, 2019, 70));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Toyota", "Prius", 27000, 2019, 1100));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Hyundai", "i22-A", 19000, 2019, 2000));


        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Audi", "Q3", 34000, 2018, 20));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Audi", "A8", 32000, 2018, 17));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Jaguar", "K-Jaguar", 29000, 2018, 100));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Volvo", "Truck-Volvo", 20000, 2018, 200));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mercedes-Benz", "HighEnd", 25000, 2018, 400));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mitsubishi", "J-Mitsubishi", 22000, 2018, 700));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Volkswagen", "Polo", 11000, 2018, 1000));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Tesla", "Tesla-S", 61000, 2018, 600));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Honda", "Acura", 22000, 2018, 90));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Dodge", "D-734", 15000, 2018, 500));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "BMW", "i3-A", 45000, 2018, 70));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Toyota", "Prius", 27000, 2018, 1100));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Hyundai", "i22-A", 19000, 2018, 2000));

        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Audi", "Q3", 34000, 2017, 22));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Audi", "A8", 32000, 2017, 32));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Jaguar", "K-Jaguar", 29000, 2017, 100));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Volvo", "Truck-Volvo", 20000, 2017, 200));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mercedes-Benz", "HighEnd", 25000, 2017, 400));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mitsubishi", "J-Mitsubishi", 22000, 2017, 700));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Volkswagen", "Polo", 11000, 2017, 1000));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Tesla", "Tesla-S", 61000, 2017, 600));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Honda", "Acura", 22000, 2017, 90));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Dodge", "D-734", 15000, 2017, 500));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "BMW", "i3-A", 45000, 2017, 70));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Toyota", "Prius", 27000, 2017, 1100));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Hyundai", "i22-A", 19000, 2017, 2000));

        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mazda", "CX-3", 17000, 2017, 500));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mazda", "MAZDA6", 19000, 2017, 70));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mazda", "CX-9", 18000, 2017, 1100));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mazda", "MX-5", 20000, 2017, 2000));

        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mazda", "CX-3", 17000, 2018, 500));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mazda", "MAZDA6", 19000, 2018, 70));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mazda", "CX-9", 18000, 2018, 1100));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mazda", "MX-5", 20000, 2018, 2000));

        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mazda", "CX-3", 17000, 2019, 500));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mazda", "MAZDA6", 19000, 2019, 70));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mazda", "CX-9", 18000, 2019, 1100));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mazda", "MX-5", 20000, 2019, 2000));

        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mazda", "CX-3", 18000, 2020, 500));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mazda", "MAZDA6", 20000, 2020, 70));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mazda", "CX-9", 21000, 2020, 1100));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Mazda", "MX-5", 22000, 2020, 2000));

        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Nissan", "Rogue SV", 19000, 2017, 20));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "Jeep", "Wrangler Unlimited Sport", 25000, 2017, 27));
        //INFINITI
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "INFINITI", "QX50", 50000, 2020, 27));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "INFINITI", "QX50", 480000, 2019, 10));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "INFINITI", "QX50", 47000, 2018, 100));
        lisOfCars.add(new Car(sequenceGenerator.nextIdStr(), "INFINITI", "QX50", 46000, 2017, 211));

        makeLisOfCar2(lisOfCars);
        repositories.dropCars2();
        repositories.saveAllCars2(lisOfCars2);

    }

    private void makeLisOfCar2(List<Car> lsOfCari) {
        lisOfCars2 = lsOfCari.stream().map(cari -> fromCarToCar2(cari)).collect(Collectors.toList());

    }

    private Car2 fromCarToCar2(Car cari) {
        Car2 car2 = new Car2();
        car2.setCarRefId(cari.getCarRefId());
        car2.setBrand(cari.getBrand());
        car2.setModel(cari.getModel());
        car2.setYearMade(cari.getYearMade());
        noOfCarEntries++;
        noOfCarEntries = (noOfCarEntries < minNoOfCarEntries) ? minNoOfCarEntries : noOfCarEntries;
        noOfCarEntries = (noOfCarEntries > maxNoOfCarEntries) ? maxNoOfCarEntries : noOfCarEntries;
        List<Car2Entry> lisOfEntries = new ArrayList<>(noOfCarEntries);
        int i = 0;

        while (i < noOfCarEntries) {
            Car2Entry car2Entry = new Car2Entry();
            car2Entry.setAveragePrice(cari.getAveragePrice() + i);
            car2Entry.setNoOfCarsSold(cari.getNoOfCarsSold());
            car2Entry.setNoOfCarsAvailable(cari.getNoOfCarsSold() / 2);
            colorInx = ++colorInx > 21 ? 0 : colorInx;
            car2Entry.setColor(ColorName.getColorName(colorInx));
            lisOfEntries.add(car2Entry);
            i++;
        }
        car2.setLisByColor(lisOfEntries) ;
        return car2 ;


    }
}
