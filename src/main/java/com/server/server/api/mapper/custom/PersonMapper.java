package com.server.server.api.mapper.custom;

import com.server.server.api.data.vo.v2.PersonVOV2;
import com.server.server.api.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {
    public PersonVOV2 convertEntityToVOV2(Person person) {
        final PersonVOV2 vo = new PersonVOV2();

        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setBirthDay(new Date());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());

        return vo;
    }

    public Person convertPersonVOV2ToPerson(PersonVOV2 person) {
        final Person entity = new Person();

        entity.setId(person.getId());
        entity.setAddress(person.getAddress());
//        entity.setBirthDay(person.getBirthDay());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());

        return entity;
    }
}