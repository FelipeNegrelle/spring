package com.server.server.api.services;

import com.server.server.api.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        final List<Person> people = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            final Person person = new Person();

            person.setId(counter.incrementAndGet());
            person.setFirstName("John" + i);
            person.setLastName("Doe");
            person.setAddress("123 Main St.");
            people.add(person);
        }

        logger.info("findAll");

        return people;
    }

    public Person findById(String id) {
        logger.info("findById: " + id);

        final Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setAddress("123 Main St.");

        return person;
    }

    public Person create(Person person) {
        logger.info("create: " + person.getFirstName());

        return person;
    }

    public Person update(Person person) {
        logger.info("update: " + person.getFirstName());

        return person;
    }

    public void delete(String id) {
        logger.info("delete: " + id);
    }
}
