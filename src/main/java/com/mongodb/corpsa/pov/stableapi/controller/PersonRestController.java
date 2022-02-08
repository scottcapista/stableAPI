package com.mongodb.corpsa.pov.stableapi.controller;

import com.mongodb.corpsa.pov.stableapi.model.Person;
import com.mongodb.corpsa.pov.stableapi.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonRestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(PersonRestController.class);
    private final PersonRepository personRepository;

    public PersonRestController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping(value = "/byName/{firstName}/{lastName}/{version}")
    public Person getPersonByName(@PathVariable("firstName") String firstName,
                                  @PathVariable("lastName") String lastName,
                                  @PathVariable(value = "version", required = false) int version){
        if (version==0) {
            LOGGER.info("Using Default Driver API");
            return personRepository.findPersonByName(firstName, lastName);
        } else {
            LOGGER.info("Using Versioned Driver API");
            return personRepository.findVersionedPersonByName(firstName, lastName);
        }
    }
}
