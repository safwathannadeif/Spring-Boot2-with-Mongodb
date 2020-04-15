package com.mongo.repo;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.mongodb.core.aggregation.*;

//import java.util.HashMap;
//import java.util.Map;
//
//public class AddExposeFieldOperation implements FieldsExposingAggregationOperation { // FieldsExposingAggregationOperation extends AggregationOperation
//    String nameToAdd1 = "NYYYYY";
//    Long valueToAdd1 = 120001l;
//    //
//    String nameToAdd2 = "NXXXXX";
//    String valueToAdd2 = "VXXXX";
//    //
//    String nameToAdd3= "multiRes" ;
//    Map<String,Object> mapToAdd = new HashMap<>() ;
//
//    public AddExposeFieldOperation() {
//    }
//    public AddExposeFieldOperation add(String name, Object value) {
//        mapToAdd.put(name,value) ;
//        return this;
//    }
//    @Override
//    public Document toDocument(final AggregationOperationContext context) {        //from AggregationOperation
//        Bson newField3 = multiplyX("$averagePrice", String.valueOf(100));	//name   $averagePrice  value newField2 can be also  map pare names/values without function like mutipl
//        // Returning a MongoDB stage here: {"$addFields: {...}}
////        mapToAdd.put(nameToAdd1,valueToAdd1) ;
////        mapToAdd.put(nameToAdd2,valueToAdd2) ;
////        ////  ("multiRes", newField2));
////        mapToAdd.put(nameToAdd3,newField3) ;
//        // return new Document("$addFields", new Document(nameToAdd1, valueToAdd1));  //can be Multiple name/value pair as map key/value
//        return new Document("$addFields", new Document(mapToAdd));  //can be Multiple name/value pair as map key/value
//    }
//    @Override
//    public ExposedFields getFields() {
//        // Field f = Fields.field(nameToAdd1);
//        // return ExposedFields.synthetic(Fields.from(f));
//        Field nameExposedFields = Fields.field(nameToAdd1,nameToAdd2);
//        return ExposedFields.synthetic(Fields.from(nameExposedFields)) ;
//    }
//    @Override
//    public boolean inheritsFields() {
//        return true;
//    }
//    //
//    public AddExposeFieldOperation done() {
//        return this;
//    }
//    //  multip
//    public static Bson multiplyX(String field1, String field2) {
//        BasicDBList multipArgs = new BasicDBList();
//        multipArgs.add(field1);
//        multipArgs.add(field2);
////{ $multiply: [ <expression1>, <expression2>, ... ] }
//        return new BasicDBObject("$multiply", multipArgs);
//    }
//    //    private Bson sqr( Bson o) {
////        BasicDBList list = new BasicDBList();
////        list.add(o);
////        list.add(2);
////        return new BasicDBObject("$pow", list);
////    }
//}