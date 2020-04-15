package com.mongo.app;
import com.mongo.entity.Car;
import com.mongo.entity.CarSaleTotal;
import com.mongo.repo.Repositories;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
public class CarSalesAggregation implements DoRunIF {
    protected final Log logger = LogFactory.getLog(getClass());
    @Override
    public void doRun(Repositories repositories) {
        logger.info("%%%%%%%% Car All %%%%%%%%");
        List<CarSaleTotal> all1 = repositories.aggregationByAll(); //findAllCars   //aggregationByAll
        for (CarSaleTotal sales : all1) {
            logger.info(sales.toString());
        }
        int year=2020 ;
        List<CarSaleTotal> all2 = repositories.aggregationByYear(year);
        logger.info("%%%%%%%% Car ByYear " + year +"    %%%%%%%%");
        for (CarSaleTotal sales : all2) {
            logger.info(sales.toString());
        }
        List<CarSaleTotal> all3 = repositories.aggregationByBrandUsedIn("Jaguar","Mitsubishi" );
        logger.info("%%%%%%%% Car In Brand Match Jaguar,Mitsubishi.. %%%%%%%%");
        for (CarSaleTotal sales : all3) {
            logger.info(sales.toString());
        }
// aggregationByBrandUsedIn
//        logger.info("%%%%%%%% Car By Brand Year %%%%%%%%");
//        List<CarSaleTotal> all2 = repositories.aggregationByBrand();
//        for (CarSaleTotal sales : all2) {
//            logger.info(sales);
//        }
    }
}
