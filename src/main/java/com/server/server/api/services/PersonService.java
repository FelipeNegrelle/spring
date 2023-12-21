package com.server.server.api.services;

import com.server.server.api.data.vo.v1.PersonVO;
import com.server.server.api.data.vo.v2.PersonVOV2;
import com.server.server.api.exceptions.ResourceNotFoundException;
import com.server.server.api.mapper.Mapper;
import com.server.server.api.mapper.custom.PersonMapper;
import com.server.server.api.model.Person;
import com.server.server.api.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();

    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonMapper personMapper;

    public List<PersonVO> findAll() {
        logger.info("findAll");

        return Mapper.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findById(long id) {
        logger.info("findById: " + id);

        final Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found for this id: " + id));

        return Mapper.parseObject(person, PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        logger.info("create: " + person.getFirstName());

        final Person personEntity = Mapper.parseObject(person, Person.class);

        return Mapper.parseObject(personRepository.save(personEntity), PersonVO.class);
    }

    public PersonVOV2 createV2(PersonVOV2 person) {
        logger.info("create: " + person.getFirstName());

        final Person personEntity = personMapper.convertPersonVOV2ToPerson(person);

        return personMapper.convertEntityToVOV2(personRepository.save(personEntity));
    }

    public PersonVO update(PersonVO person) {
        logger.info("update: " + person.getFirstName());

        final Person personEntity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found for this id: " + person.getId()));

        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        personEntity.setAddress(person.getAddress());
        personEntity.setGender(person.getGender());

        return Mapper.parseObject(personRepository.save(personEntity), PersonVO.class);
    }

    public void delete(long id) {
        logger.info("delete: " + id);

        final Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found for this id: " + id));

        personRepository.delete(entity);
    }
}
