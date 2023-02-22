package com.example.onlineshop.dao;

import com.example.onlineshop.ds.Item;
import de.flapdoodle.embed.mongo.packageresolver.Command;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

@Component
public class TemplateDatabaseLoader {
    //@Bean
    public CommandLineRunner initialize(MongoOperations mongo){
        return args -> {
            mongo.save(new Item("Alf alarm clock",19.99));
            mongo.save(new Item("Smurf TV Tray",24.99));
        };
    }
}
