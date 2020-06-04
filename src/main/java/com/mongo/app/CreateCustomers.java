//https://www.mockaroo.com/schemas/download   --mock data
// https://www.randomlists.com/canadian-addresses?qty=600 mock data
package com.mongo.app;
import com.mongo.entity.Car;
import com.mongo.entity.CarCusInfo;
import com.mongo.entity.Customer;
import com.mongo.gutil.ColorName;
import com.mongo.repo.Repositories1;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreateCustomers implements DoRunIFWithRepo<Repositories1> {
    protected final Log logger = LogFactory.getLog(getClass());
    private int noOfCars = -1;
    private final int MaxCarPerCustomer = 4;
    private List<Car> lisofDbCars = null;
    private int currentCarInx = -1;
    private int colorInx = -1;
    @Override
    public void doRun1(Repositories1 repositories) {
        lisofDbCars = repositories.findAllCars();
        repositories.dropCustomers(); ;
        List<Customer> lisOfCus = IntStream.range(1, 100).mapToObj(i -> makeNewCustomer(i)).collect(Collectors.toList());
        repositories.saveAllCustomers(lisOfCus);
    }
    private Customer makeNewCustomer(int i) {
        noOfCars = (++noOfCars > MaxCarPerCustomer) ? 0 : noOfCars;
        List<String> refToCars = IntStream.range(0, noOfCars).mapToObj(n -> getIdRefOneCar()).collect(Collectors.toList());
        List<CarCusInfo> carCusInfos = IntStream.range(0, noOfCars).mapToObj(n -> getCarInfo(n)).collect(Collectors.toList());
        Customer cus =  new Customer("name-" + i, "cusId-" + i, carCusInfos, refToCars ) ;
        return cus ;
    }
    private String getIdRefOneCar()
    {
        currentCarInx = (++currentCarInx == lisofDbCars.size()) ? 0 : currentCarInx;
        Car car = lisofDbCars.get(currentCarInx) ;
        int year = car.getYearMade() ;
       return(lisofDbCars.get(currentCarInx).getCarRefId()) ;

    }
    private CarCusInfo getCarInfo(int j)  {
        CarCusInfo carCusInfo = new CarCusInfo() ;
        colorInx = (++colorInx > 10) ? 0 : colorInx;
        carCusInfo.setCarColor(ColorName.getColorName(colorInx));
        carCusInfo.setPlateId("plt-"+j+1*colorInx+"-"+j+2+600*colorInx +"-"+ colorInx);
        carCusInfo.setCarMileage(j*1000+ colorInx*150);
        return carCusInfo ;
    }
}
