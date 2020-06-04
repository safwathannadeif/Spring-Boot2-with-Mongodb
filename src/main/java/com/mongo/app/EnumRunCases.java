package com.mongo.app;
public enum EnumRunCases {
    RunCreateCars1(CreateCars.class, "R1_CreateCars", RepoDbCases.Repo1),
    RunAggregationCarSales2(CarSalesAggregation.class,"R2_AggregationCarSales", RepoDbCases.Repo1),
    RunCreateCustomers3(CreateCustomers.class,"R3_CreateCustomers", RepoDbCases.Repo1),
    RunFindCustomerAndCars4(FindCustomerAndCars.class,"R4_FindCustomerAndCars",RepoDbCases.Repo1) ,
    RunFindBy5(FindBy.class,"R5_FindBy",RepoDbCases.Repo1) ,
    RunCreate2Cars6(Create2Cars.class,"R6_Create2Cars",RepoDbCases.Repo2) ,
    ;
   // RunFieldsExposingGeneralTest6(FieldsExposingGeneralTest.class,"R6_FieldsExposingGeneralTest6") ;
    //MongoFilterGeneric
    // ;

    private  Class<? extends DoRunIFWithRepo>  clz ;
    private final String runId;
    private  RepoDbCases repoDbCases;

    private EnumRunCases(Class<? extends DoRunIFWithRepo>  clzi, String runNoi, RepoDbCases repoDbCases) {
        this.clz = clzi;
        this.runId = runNoi;
        this.repoDbCases=repoDbCases ;
    }
    public Class<? extends DoRunIFWithRepo> getClz() {
        return clz;
    }
    public String getRunId() {
        return runId;
    }
    public RepoDbCases getRepoDbCases() {
        return this.repoDbCases;
    }
    public enum RepoDbCases {
        Repo1("RepoDb1",1) ,  Repo2("RepoDb2",2)  ;

        public String getRepoName() {
            return repoName;
        }

        public int getRepoId() {
            return repoId;
        }

        private final String repoName ;
        private final int repoId ;
        private RepoDbCases(String repo, int repoId) {
            this.repoName=repo ;
            this.repoId=repoId ;
        }



    }

}

