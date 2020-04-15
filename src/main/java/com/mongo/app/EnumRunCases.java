package com.mongo.app;
public enum EnumRunCases {
    RunCreateCars1(CreateCars.class, "R1_CreateCars"),
    RunAggregationCarSales2(CarSalesAggregation.class,"R2_AggregationCarSales"),
    RunCreateCustomers3(CreateCustomers.class,"R3_CreateCustomers"),
    RunFindCustomerAndCars4(FindCustomerAndCars.class,"R4_FindCustomerAndCars") ,
    RunFindBy5(FindBy.class,"R5_FindBy") ;
   // RunFieldsExposingGeneralTest6(FieldsExposingGeneralTest.class,"R6_FieldsExposingGeneralTest6") ;
    //MongoFilterGeneric
    // ;

    private  Class<? extends DoRunIF>  clz ;
   private final String runId;

    private EnumRunCases(Class<? extends DoRunIF>  clzi, String runNoi) {
        this.clz = clzi;
        this.runId = runNoi;
    }
    public Class<? extends DoRunIF> getClz() {
        return clz;
    }
    public String getRunId() {
        return runId;
    }
}
