package com.server.server.api.services;

import com.server.server.api.controllers.PersonController;
import com.server.server.api.data.vo.v1.PersonVO;
import com.server.server.api.data.vo.v2.PersonVOV2;
import com.server.server.api.exceptions.RequiredObjectIsNullException;
import com.server.server.api.exceptions.ResourceNotFoundException;
import com.server.server.api.mapper.Mapper;
import com.server.server.api.mapper.custom.PersonMapper;
import com.server.server.api.model.Person;
import com.server.server.api.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();

    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonMapper personMapper;

    public List<PersonVO> findAll() throws Exception {
        logger.info("findAll");

        final List<PersonVO> voList = Mapper.parseListObjects(personRepository.findAll(), PersonVO.class);

        for (PersonVO vo : voList) {
            vo.add(linkTo(methodOn(PersonController.class).findById(vo.getUniqueKey())).withSelfRel());
        }

        return voList;
    }

    public PersonVO findById(long uniqueKey) throws Exception {
        logger.info("findById: " + uniqueKey);

        final Person person = personRepository.findById(uniqueKey).orElseThrow(() -> new ResourceNotFoundException("Person not found for this id: " + uniqueKey));

        final PersonVO vo = Mapper.parseObject(person, PersonVO.class);

        vo.add(linkTo(methodOn(PersonController.class).findById(uniqueKey)).withSelfRel());

        return vo;
    }

    public PersonVO create(PersonVO person) throws Exception {
        if (Objects.nonNull(person)) {
            logger.info("create: " + person.getFirstName());

            final Person personEntity = Mapper.parseObject(person, Person.class);

            final PersonVO vo = Mapper.parseObject(personRepository.save(personEntity), PersonVO.class);

            vo.add(linkTo(methodOn(PersonController.class).findById(vo.getUniqueKey())).withSelfRel());

            return vo;
        } else {
            throw new RequiredObjectIsNullException();
        }
    }

    public PersonVOV2 createV2(PersonVOV2 person) {
        logger.info("create: " + person.getFirstName());

        final Person personEntity = personMapper.convertPersonVOV2ToPerson(person);

        return personMapper.convertEntityToVOV2(personRepository.save(personEntity));
    }

    public PersonVO update(PersonVO person) throws Exception {
        if (!Objects.nonNull(person)) {
            logger.info("update: " + person.getFirstName());

            final Person personEntity = personRepository.findById(person.getUniqueKey()).orElseThrow(() -> new ResourceNotFoundException("Person not found for this id: " + person.getUniqueKey()));

            personEntity.setFirstName(person.getFirstName());
            personEntity.setLastName(person.getLastName());
            personEntity.setAddress(person.getAddress());
            personEntity.setGender(person.getGender());

            final PersonVO vo = Mapper.parseObject(personRepository.save(personEntity), PersonVO.class);

            vo.add(linkTo(methodOn(PersonController.class).findById(vo.getUniqueKey())).withSelfRel());

            return vo;
        } else {
            throw new RequiredObjectIsNullException();
        }
    }

    public void delete(long id) {
        logger.info("delete: " + id);

        final Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found for this id: " + id));

        personRepository.delete(entity);
    }
}
