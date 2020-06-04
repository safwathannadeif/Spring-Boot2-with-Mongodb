package com.mongo.cfg;

import com.mongodb.MongoClientURI;
import com.mongodb.WriteConcern;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.WriteResultChecking;

   @SuppressWarnings("ALL")
    @Configuration ("Config2")
    public class ConfigMongoDB2 {
        protected final Log logger = LogFactory.getLog(getClass());
        private @Value("${uriMongoDbClient2}")
        String uri;
        public MongoDbFactory mongoDbFactory() {
            return new SimpleMongoDbFactory(new MongoClientURI(uri));
        }
        @Bean ("BTemplate2")              //Singleton Bean
        public MongoTemplate getMongoTemplate2() {
            logger.info("......................................  getMongoTemplate2   Called...........");
            MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
            mongoTemplate.setWriteConcern(WriteConcern.ACKNOWLEDGED) ;
            mongoTemplate.setWriteResultChecking(WriteResultChecking.EXCEPTION);
            return mongoTemplate;
        }
    }
