package com.mongo.ctlr;

import com.mongo.entity.*;
import com.mongo.gutil.SequenceGenerator;
import com.mongo.repo.Repositories1;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@ComponentScan("com.mongo.repo")

@RequestMapping("/car")
public class SprController {
    protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    Repositories1 repositories;

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
    //
    @GetMapping("/getCusByCusId/{cusId}")   ///{ownerId}
    public CusCarDetailsDisplay getCusByCusIdname(@PathVariable String cusId) throws InterruptedException {
        Thread.sleep(10000);
        logger.info("getCusByCusId  Started cusId=" + cusId );
        List<CustomerCarDb> lis1 = repositories.lookupCusCarByCustomerName(cusId, Repositories1.FindCusByCases.FindByCusid ) ;
        if ( lis1.size() == 0 ) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Not Found");
        //  List<CusCarDetailsDisplay> displyCusList =lis1.stream().map(xcuscarDb-> makeCusCarDetails(xcuscarDb)).collect(Collectors.toList());
        CusCarDetailsDisplay cusCarDetailsDisplay = makeCusCarDetails(lis1.get(0) ) ;
        return(cusCarDetailsDisplay) ;

    }
    //
    @GetMapping("/getCusByName/{name}")   ///{ownerId}
    public CusCarDetailsDisplay getCusByname(@PathVariable String name) {
        logger.info("getCusByName  Started name=" + name );
        List<CustomerCarDb> lis1 = repositories.lookupCusCarByCustomerName(name, Repositories1.FindCusByCases.FindByCusName ) ;
        if ( lis1.size() == 0 ) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Not Found");
      //  List<CusCarDetailsDisplay> displyCusList =lis1.stream().map(xcuscarDb-> makeCusCarDetails(xcuscarDb)).collect(Collectors.toList());
        CusCarDetailsDisplay cusCarDetailsDisplay = makeCusCarDetails(lis1.get(0) ) ;
        return(cusCarDetailsDisplay) ;

    }
    private CusCarDetailsDisplay makeCusCarDetails(CustomerCarDb customerCarDb)
    {
        if ( customerCarDb.getLisOfCarInfo().size() !=  customerCarDb.getLisOfFoundCars().size()) throw new RuntimeException("size not matching") ;
        CusCarDetailsDisplay cusCarDetailsDisplay = new CusCarDetailsDisplay() ;
        List<CusCarDetailsElmDisplay> outMergedList = new ArrayList<>(customerCarDb.getLisOfFoundCars().size()) ;
        for (int i=0 ; i< customerCarDb.getLisOfCarInfo().size();i++)  {
            CusCarDetailsElmDisplay cusCarDetails = new CusCarDetailsElmDisplay() ;
            cusCarDetails.setModel(customerCarDb.getLisOfFoundCars().get(i).getModel());
            cusCarDetails.setBrand(customerCarDb.getLisOfFoundCars().get(i).getBrand());
            cusCarDetails.setSalesyear(customerCarDb.getLisOfFoundCars().get(i).getYearMade());
            cusCarDetails.setPlateId(customerCarDb.getLisOfCarInfo().get(i).getPlateId());
            cusCarDetails.setCarColor(customerCarDb.getLisOfCarInfo().get(i).getCarColor());
            cusCarDetails.setCarMileage(customerCarDb.getLisOfCarInfo().get(i).getCarMileage());
            outMergedList.add(cusCarDetails) ;
        }
        cusCarDetailsDisplay.setCusCarDetailsElmListDisplay(outMergedList);
        cusCarDetailsDisplay.setCusId(customerCarDb.getCusId());
        cusCarDetailsDisplay.setName(customerCarDb.getName());
        return cusCarDetailsDisplay ;
    }


}