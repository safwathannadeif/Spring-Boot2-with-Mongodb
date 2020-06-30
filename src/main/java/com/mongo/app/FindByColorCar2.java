package com.mongo.app;
import com.mongo.entity.Car2;
import com.mongo.repo.Repositories2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class FindByColorCar2 implements DoRunIFWithRepo<Repositories2> {
    protected final Log logger = LogFactory.getLog(getClass());
    protected int noOfCarEntries = 0;
    protected int colorInx = -1;
    protected final int minNoOfCarEntries = 2;
    protected final int maxNoOfCarEntries = 11;
    protected List<Car2> lisOfCars2 = new ArrayList<>();
    @Override
    public void doRun1(Repositories2 repositories) {
        List<Car2> car2Lis = repositories.findByColor("RED" ) ;
        car2Lis.forEach(cr -> logger.info(cr.toString()));
    }
}