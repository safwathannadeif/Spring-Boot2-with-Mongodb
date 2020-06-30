package com.mongo.app;
import com.mongo.entity.Car2;
import com.mongo.entity.Customer2Car2Db;
import com.mongo.repo.Repositories2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
public class LookUpCus2Cars2 implements DoRunIFWithRepo<Repositories2> {
    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public void doRun1(Repositories2 repositories) {
        List<Customer2Car2Db>  outLis2 =    repositories.cus2WithCars2() ;
        logger.info(outLis2);
    }
}



