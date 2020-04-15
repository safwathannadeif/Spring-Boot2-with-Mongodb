//package com.mongo.app;
//import com.mongo.entity.Car;
//import com.mongo.entity.Customer;
//import com.mongo.entity.CustomerCar;
//import com.mongo.repo.Repositories;
//import com.mongodb.DB;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//@ComponentScan("com.mongo.repo")
//@SpringBootApplication
//public class DoBuildAndTestCustomersDB {
//    public static void main(String[] args) {
//        SpringApplication.run(DoBuildAndTestCustomersDB.class, args);
//    }
//    //
//    @Order(value = 1)
//    @Component
//    class createCustomers implements CommandLineRunner {
//        @Autowired
//        Repositories repositories;
//        //
//        public List<Car> lisOfCars;
//        private int nextcar = -1;
//        public List<Customer> lisOfCustomers;
//        protected final Log logger = LogFactory.getLog(getClass());
//        private int noOfItems = 0 ;
//        private Customer makeNewCustomer(int i) {
//            return (new Customer("Name-" + i, "cus" + i * 100, getCarRefIdLisFromList()));
//        }
//        private List<Long> getCarRefIdLisFromList() {
//            noOfItems++ ;
//            if (noOfItems > 4) noOfItems= 1 ;
//            List<Long> outLis = new ArrayList<>() ;
//            for ( int k =0 ; k <=noOfItems ; k++)  {
//                nextcar++;
//                if (nextcar == lisOfCars.size()) nextcar = 0;
//                outLis.add(lisOfCars.get(nextcar).getCarRefId());
//            }
//
//         return(outLis) ;
//        }
//        @Override
//        public void run(String... args) throws Exception {
//            lisOfCustomers = repositories.findAllCustomers();
//
//            List<CustomerCar> lisOfCusAndCar = repositories.lookupTry1();
//            logger.info("Return lookupTry1 Size=" + lisOfCusAndCar.size());
//            lisOfCusAndCar.forEach(cuscar -> logger.info(cuscar.toString()));
//            /* ---------- Done
//            lisOfCars = repositories.findAllCars();
//            lisOfCars.forEach(car -> logger.info(car.toString()));
//            lisOfCustomers = repositories.findAllCustomers();
//            lisOfCustomers.forEach(cus -> logger.info(cus.toString()));
//            */
//
//            /* ---------- Done
//            List<Customer> lisOfCus = IntStream.range(1, 100).mapToObj(i -> makeNewCustomer(i)).collect(Collectors.toList());
//            repositories.saveAllCustomers(lisOfCus);
//            lisOfCars = repositories.findAllCars();
//            lisOfCars.forEach(car -> logger.info(car.toString())) ;
//            lisOfCustomers = repositories.findAllCustomers();
//            lisOfCustomers.forEach(cus -> logger.info(cus.toString()));
//           */
//        }
//    }
//}