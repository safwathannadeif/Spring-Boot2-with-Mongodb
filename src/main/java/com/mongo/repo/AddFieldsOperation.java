//package com.mongo.repo;
//import com.mongodb.BasicDBList;
//import com.mongodb.BasicDBObject;
//import org.bson.Document;
//import org.bson.conversions.Bson;
//import org.springframework.data.mongodb.core.aggregation.*;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//
//public class AddFieldsOperation implements FieldsExposingAggregationOperation {
//
//    private Map<String, Object> fields = new LinkedHashMap<>();
//
//    public AddFieldsOperation() { } ;
//    public AddFieldsOperation(String field, AggregationExpression expression) {
//        addField(field, expression);
//    }
//
//    public AddFieldsOperation addField(String field, AggregationExpression expression) {
//        this.fields.put(field, expression.toDocument(Aggregation.DEFAULT_CONTEXT));
//        return this;
//    }
//    @Override
//    public Document toDocument(AggregationOperationContext context) {
//        Document doc = new Document();
//        fields.forEach(doc::append);
//        return new Document("$addFields", doc);
//    }
//    @Override
//    public boolean inheritsFields() {
//        return true;
//    }
//    @Override
//    public ExposedFields getFields() {
//        final String[] fieldsArray = fields.keySet().toArray(new String[0]);
//        return ExposedFields.synthetic(Fields.fields(fieldsArray));
//    }
//}
//