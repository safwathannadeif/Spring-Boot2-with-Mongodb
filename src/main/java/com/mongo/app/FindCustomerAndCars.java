package com.mongo.app;
import com.mongo.entity.CusCarDetailsDisplay;
import com.mongo.entity.CusCarDetailsElmDisplay;
import com.mongo.entity.CustomerCarDb;
import com.mongo.repo.Repositories;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class FindCustomerAndCars implements DoRunIF {
    protected final Log logger = LogFactory.getLog(getClass());
    @Override
    public void doRun(Repositories repositories) {

    // run-1 By one Cus id One Cus         List<CustomerCarDb> lis2  = repositories.lookupCusCarByCustomerName("name-10") ;
        List<String> lisOfCusIds = Arrays.asList("name-1","name-10","name-15" ) ;
// run-2 for List of Customers
       List<CustomerCarDb> lis2 = repositories.lookupCusCarByCustomerNameList(lisOfCusIds) ;
       // List<CustomerCarDb> lis2 = repositories.lookupCusCarByCustomerName("name-10") ;
        logger.info("Size:" + lis2.size() ) ;
        lis2.forEach(c2-> logger.info(c2.toString()));
        List<CusCarDetailsDisplay> displyCusList =lis2.stream().map(xcuscarDb-> makeCusCarDetails(xcuscarDb)).collect(Collectors.toList());
        logger.info("Strat Disp");
        displyCusList.forEach(disp-> {logger.info(disp.toString()) ;
        logger.info("End Disp");
        });
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
