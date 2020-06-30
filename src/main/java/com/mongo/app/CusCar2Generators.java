package com.mongo.app;
import com.mongo.entity.Car2;
import com.mongo.entity.CarCusInfo2;
import com.mongo.entity.Customer2;
import com.mongo.gutil.SequenceGenerator;
import com.mongo.repo.Repositories2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
public class CusCar2Generators implements DoRunIFWithRepo<Repositories2> {
    private static SequenceGenerator sequenceGenerator = new SequenceGenerator();

    //@Autowired
    //@Qualifier("Repo2")
    public Repositories2 repositories2;
    private List<Customer2> lisCusout;
    private List<pairOfCarAndIndex> pairOfCarAndIndexList = new ArrayList<>();
    private Integer carIndex = -1;
    private Integer cusIndex = -1;
    private Integer delta = 0;
    private Integer deleteStart = 1;
    private Integer deleteEnd = 21;
    private Integer noOfcarsPerCus = 4;
    private Integer Totrecords = 0;
    @Override
    public void doRun1(Repositories2 repositories) {
        this.repositories2 = repositories;
        CusCar2Generators cusCarGenerators = new CusCar2Generators();
        cusCarGenerators.repositories2 = repositories ;
        try {
            cusCarGenerators.generateCusWithCars();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void debugRead(Customer2 cdb) {
        System.out.println(cdb.toString());
    }
    public void generateCusWithCars() throws IOException {
        makeCustomers();
        getDbAllCars();
        lisCusout.forEach(cusi -> addCarToCustomer(cusi));
        lisCusout.forEach(cusi -> debugRead(cusi));
        System.out.println(Totrecords) ;
        repositories2.saveAllCustomers2(lisCusout);
    }
    public void addCarToCustomer(Customer2 cus) {
        noOfcarsPerCus = ++noOfcarsPerCus > 11 ? 3 : noOfcarsPerCus;
        int loopNo = 0;
        while (loopNo <= noOfcarsPerCus) {
            CarCusInfo2 carCusInfo = new CarCusInfo2();
            delta = ++delta > deleteEnd ? deleteStart : delta;
            pairOfCarAndIndex carWithColortoAdd = getNextCarColorIndexPair();
            carWithColortoAdd.colorIndex++;
            if (carWithColortoAdd.colorIndex == carWithColortoAdd.getCar2().getLisByColor().size())
                carWithColortoAdd.colorIndex = 0;
            carCusInfo.setCarColor(carWithColortoAdd.getCar2().getLisByColor().get(carWithColortoAdd.colorIndex).getColor());
            carCusInfo.setCarIdRef(carWithColortoAdd.getCar2().getCarRefId());
            carCusInfo.setPlatelicense(generatePlatelicense(cus));
            carCusInfo.setDateOfSell(generateDateOfSell(carWithColortoAdd.getCar2()));
            carCusInfo.setPurchasePrice (carWithColortoAdd.getCar2().getLisByColor().get(0).getAveragePrice() * (delta + 1 / deleteEnd - delta + 2));
            carCusInfo.setBookValue(carWithColortoAdd.getCar2().getLisByColor().get(0).getAveragePrice()*(1/10*delta+1)); ;
            carCusInfo.setCarMileage(noOfcarsPerCus*750*delta + delta);
            carCusInfo.setRemark("....") ;
            cus.getLisOfCarSInfo().add(carCusInfo);
            ++loopNo ;
            ++Totrecords;

        }
    }
    public Customer2 getNextCus() {
        cusIndex++;
        if (cusIndex == lisCusout.size()) cusIndex = 0;
        return lisCusout.get(cusIndex);
    }
    public pairOfCarAndIndex getNextCarColorIndexPair() {
        carIndex = ++carIndex == pairOfCarAndIndexList.size() ? 0 : carIndex;
        return pairOfCarAndIndexList.get(carIndex);
    }
    public void getDbAllCars() {
        repositories2.findAllCars2() ;
        pairOfCarAndIndexList = repositories2.findAllCars2().stream().map(car -> new pairOfCarAndIndex(car, -1)).collect(toList());
    }
    public void makeCustomers() throws IOException {
        String path = "C:\\DataFiles\\MOCK_DATA2.csv";
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            lisCusout = lines.map(l -> new Customer2(l.split(",", 11))).collect(toList());
        }
    }
    private String generateDateOfSell(Car2 car2) {
        LocalDate sourceDate = LocalDate.of(car2.getYearMade(), Month.JANUARY, delta);  // Source Date
        LocalDate destDate = sourceDate.plusDays(delta * 3); // Adding a day to source date.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // Setting date format
        return (destDate.format(formatter));
    }
    private String generatePlatelicense(Customer2 customer2CarDB) {
        StringBuilder sb = new StringBuilder(customer2CarDB.getCity().substring(1, 4).toUpperCase()).
                append(customer2CarDB.getInsuranceCompany().substring(1, 2).toUpperCase()).
                append(customer2CarDB.getStates().substring(0, 3).toUpperCase());
        return (sb.reverse().append(sequenceGenerator.nextIdStr()).toString());
    }
    public class pairOfCarAndIndex {
        private Car2 car2;
        private Integer colorIndex;
        public pairOfCarAndIndex(Car2 car2i, Integer colorIndexi) {
            car2 = car2i;
            colorIndex = colorIndexi;
        }
        public Car2 getCar2() {
            return car2;
        }
        public void setCar2(Car2 car2) {
            this.car2 = car2;
        }
        public Integer getColorIndex() {
            return colorIndex;
        }
        public void setColorIndex(Integer colorIndex) {
            this.colorIndex = colorIndex;
        }
    }

}
