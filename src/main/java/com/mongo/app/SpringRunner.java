package com.mongo.app;
import com.mongo.repo.Repositories;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan("com.mongo.repo")
@SpringBootApplication
public class SpringRunner {
    @Autowired
    Repositories repositories;
    public static void main(String[] args) {
     SpringApplication.run(SpringRunner.class, args);
    }
    //
    //@Order(value = 1)
////////  Temp @Component
////////  Temp  class CmdLineRun implements CommandLineRunner {
        @Autowired
        private ConfigurableApplicationContext context;
        protected final Log logger = LogFactory.getLog(getClass());
        private  EnumRunCases runCase ;
        //
//////////        TEMP   @Override
        public void run(String... args) throws Exception {
//Make one run with the runCase
//-1   runCase =EnumRunCases.RunCreateCars1 ;
//-2   runCase =EnumRunCases.RunAggregationCarSales2 ;
//-3    runCase =EnumRunCases.RunCreateCustomers3 ;
//-4    runCase= EnumRunCases.RunFindCustomerAndCars4
//-5    runCase =EnumRunCases.RunFindBy5 ;
//-6    runCase       runCase= EnumRunCases.RunFieldsExposingGeneralTest6 ;  ///Not Used
            runCase =runCase =EnumRunCases.RunCreateCustomers3 ;
            try {
                logger.info("Start cmdLineRun");
                logger.info("Runing RunCase=" + runCase.getRunId());
                Class<? extends DoRunIF> clz= runCase.getClz() ;
                DoRunIF doRunIFi = clz.getConstructor().newInstance() ;
                doRunIFi.doRun(repositories);
                logger.info("End cmdLineRun");
                SpringApplication.exit(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
////////  Temp}