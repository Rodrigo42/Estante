package org.drogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.mongodb.autoconfigure.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication(exclude = {
        MongoAutoConfiguration.class})
public class Estnt {
    public static void main(String[] args) {
        SpringApplication.run(Estnt.class);

    }
}
