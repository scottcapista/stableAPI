package com.mongodb.corpsa.pov.stableapi;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.corpsa.pov.stableapi.model.Address;
import com.mongodb.corpsa.pov.stableapi.model.Person;
import com.mongodb.corpsa.pov.stableapi.repositories.PersonRepository;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@SpringBootApplication
public class StableApiV2Application implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(StableApiV2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Address address = new Address(true,"WI","Madison","460 Memorial Avenue");
        ArrayList<Address> addressList = new ArrayList<>();
        addressList.add(address);
        personRepository.save(new Person("Kermy","Shildrick","Male", LocalDate.parse("1926-10-19"),addressList));
        personRepository.save(new Person("Mair","Snibson","Female", LocalDate.parse("1983-11-25"),addressList));
        personRepository.save(new Person("Theresita","Furmenger","Female", LocalDate.parse("1945-12-27"),addressList));
    }
}
