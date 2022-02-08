package com.mongodb.corpsa.pov.stableapi.repositories;

import com.mongodb.corpsa.pov.stableapi.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository {
    Person findPersonByName(String firstName, String lastName);

    Person findVersionedPersonByName(String firstName, String lastName);

    void save(Person person);
}
