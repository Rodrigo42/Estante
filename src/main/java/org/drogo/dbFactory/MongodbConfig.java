package org.drogo.dbFactory;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongodbConfig {
    private Environment env;

    public MongodbConfig(Environment env){
        this.env = env;
    }

    @Bean
    public MongoClient mongoClient(){
        String uri = env.getProperty("spring.data.mongodb.uri");
        return MongoClients.create(new ConnectionString(uri));
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient){
        String database = env.getProperty("spring.data.mongodb.database");
        return new MongoTemplate(mongoClient, database);
    }

}
