package com.mongo.cfg;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteConcern;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.WriteResultChecking;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@SuppressWarnings("ALL")
@Configuration
public class ConfigMongoDB1 {
    protected final Log logger = LogFactory.getLog(getClass());
    private @Value("${uriMongoDbClient1}")
    String uri;
    public MongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(new MongoClientURI(uri));
    }
    @Bean               //Singleton Bean
    @Primary
    public MongoTemplate getMongoTemplate() {
        logger.info("......................................  getMongoTemplate   Called...........");
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        mongoTemplate.setWriteConcern(WriteConcern.ACKNOWLEDGED);
        mongoTemplate.setWriteResultChecking(WriteResultChecking.EXCEPTION);
        return mongoTemplate;
    }
}

