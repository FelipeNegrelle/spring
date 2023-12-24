package com.server.server.unitTests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import com.server.server.api.data.vo.v1.PersonVO;
import com.server.server.api.model.Person;

public class MockPerson {
    public Person mockEntity() {
        return mockEntity(0);
    }

    public PersonVO mockVO() {
        return mockVO(0);
    }

    public List<Person> mockEntityList() {
        final List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }

        return persons;
    }

    public List<PersonVO> mockVOList() {
        final List<PersonVO> persons = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }

        return persons;
    }

    public Person mockEntity(Integer number) {
        final Person person = new Person();

        person.setAddress("Addres Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2) == 0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);

        return person;
    }

    public PersonVO mockVO(Integer number) {
        final PersonVO person = new PersonVO();

        person.setAddress("Addres Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2) == 0) ? "Male" : "Female");
        person.setUniqueKey(number.longValue());
        person.setLastName("Last Name Test" + number);

        return person;
    }
}
