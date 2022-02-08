package com.mongodb.corpsa.pov.stableapi.repositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.corpsa.pov.stableapi.model.Person;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final MongoClient mongoClient;
    private final MongoClient mongoVersionedClient;
    private MongoCollection<Person> personCollection;
    private MongoCollection<Person> personVersionedCollection;

    public PersonRepositoryImpl(MongoClient mongoClient, MongoClient mongoVersionedClient) {
        this.mongoVersionedClient = mongoVersionedClient;
        this.mongoClient = mongoClient;
    }

    @PostConstruct
    void init(){
        personCollection = mongoClient.getDatabase("test").getCollection("person", Person.class);
        personVersionedCollection = mongoVersionedClient.getDatabase("test").getCollection("person", Person.class);
    }

    @Override
    public Person findPersonByName(String firstName, String lastName){
        return personCollection.find(and(eq("firstName", firstName), eq("lastName",lastName))).first();
    }

    @Override
    public Person findVersionedPersonByName(String firstName, String lastName){
        return personVersionedCollection.find(and(eq("firstName", firstName), eq("lastName",lastName))).first();
    }

    @Override
    public void save(Person person) {
        personCollection.insertOne(person);
    }
}
