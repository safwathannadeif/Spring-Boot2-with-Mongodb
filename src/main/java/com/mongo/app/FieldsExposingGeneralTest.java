//package com.mongo.app;
//import com.mongo.entity.CarSaleTotal;
//import com.mongo.repo.Repositories;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.aggregation.*;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
////https://www.sgmoratilla.com/2019-05-23-mixing-spring-data-mongo-queries/
///**
//        * This example shows how to mix Spring Data Criteria with stages written in MongoDB syntax.
//        */
//@Component
//public class FieldsExposingGeneralTest implements DoRunIF {
//
//    protected final Log logger = LogFactory.getLog(getClass());
//    private MongoTemplate mongoTemplate;
//    private Class<?>   xClz ;
//    private String colllecionName = "cars" ;
//////   CarSaleTotal
//    @Override
//    public void doRun(Repositories repositories) {
//        mongoTemplate = repositories.getMongoTemplate() ;
//        List<CarSaleTotal> carLis = useCase() ;
//        carLis.forEach(car -> logger.info(car));
//    }
//    public FieldsExposingGeneralTest() {
//    }
//
////    public List<CarSaleTotal> useCase() {
////   // Using Spring syntax
////        Criteria match = new Criteria().where("brand").is("Volvo");
////   //  GroupOperation.GroupOperationBuilder
////        Sort sort = Sort.by("yearMade") ;
////      //  AddExposeFieldOperationForTesting addFieldOperation = new AddExposeFieldOperationForTesting() ;  //equv to FieldsExposingAggregationOperation
////     //   return doAggregate(match, addFieldOperation, sort, CarSaleTotal.class);
////    }
//    /**
//     * It receives standard Spring's Criteria and Sort, and a Spring's AggregationOperation to be use with the Spring's pipeline operation.
//     */
//    public <T> List<T>  doAggregate( Criteria match,  AggregationOperation addFieldsOperation,  Sort sort,Class<T> tClaz) {
//        MatchOperation matchOperation = Aggregation.match(match);
//        SortOperation sortOperation = Aggregation.sort(sort);
//       Aggregation agg = Aggregation.newAggregation(matchOperation,addFieldsOperation,sortOperation) ;
//        List<T> t = mongoTemplate.aggregate(agg,colllecionName,tClaz).getMappedResults();
//        return t ;
//    }
//    //// https://stackoverflow.com/questions/55282406/mongodb-addfields-using-org-springframework-data-mongodb-core-mongotemplate
////    public FieldsExposingAggregationOperation addFieldsOperation() {
////        return
////                new FieldsExposingAggregationOperation() {
////
////                    @Override
////                    public Document toDocument(AggregationOperationContext context) {
////                        // Writing MongoDB queries here, so that use the names of the fields as stored in MongoDB
////                        //Bson newField = sqr(minus("$anotherField", 1));
////                        Bson newField2 = multiply("$averagePrice", 10);
////
////                        // Returning a MongoDB stage here: {"$addFields: {...}}
////                        return new Document("$addFields",  new Document("multiRes", newField2));
////                    }
////
////                    @Override
////                    public ExposedFields getFields() {
////                        Field f = Fields.field("newField2");
////                        return ExposedFields.synthetic(Fields.from(f));
////                    }
////
////                    @Override
////                    public boolean inheritsFields() {
////                        return true;
////                    }
////                };
////    }
////
////    /**
////     * Helper methods that write operations in MongoDB syntax.
////     */
////
////    private Bson sqr( Bson o) {
////        BasicDBList list = new BasicDBList();
////        list.add(o);
////        list.add(2);
////        return new BasicDBObject("$pow", list);
////    }
////
////
////    private Bson minus(String field, double value) {
////        BasicDBList minusArgs = new BasicDBList();
////// { $add: [ <expression1>, <expression2>, ... ] }
////        minusArgs.add(field);
////        minusArgs.add(-value);
////
////        return new BasicDBObject("$add", minusArgs);
////
////    }
////    //  multip
////    private Bson multiply(String field1, int field2) {
////        BasicDBList multipArgs = new BasicDBList();
////
////        multipArgs.add(field1);
////        multipArgs.add(field2);
//////{ $multiply: [ <expression1>, <expression2>, ... ] }
////        return new BasicDBObject("$multiply", multipArgs);
////
////    }
//}