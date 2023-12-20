package com.server.server.api.services;

import com.server.server.api.exceptions.ResourceNotFoundException;
import com.server.server.api.model.Person;
import com.server.server.api.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository personRepository;

    public List<Person> findAll() {
        logger.info("findAll");

        return personRepository.findAll();
    }

    public Person findById(long id) {
        logger.info("findById: " + id);

        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id: " + id));
    }

    public Person create(Person person) {
        logger.info("create: " + person.getFirstName());

        return personRepository.save(person);
    }

    public Person update(Person person) {
        logger.info("update: " + person.getFirstName());

        Person entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id: " + person.getId()));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);
    }

    public void delete(long id) {
        logger.info("delete: " + id);

        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id: " + id));

        personRepository.delete(entity);
    }
}
