package com.server.server.unitTests.mockito;

import com.server.server.api.data.vo.v1.PersonVO;
import com.server.server.api.exceptions.RequiredObjectIsNullException;
import com.server.server.api.mapper.Mapper;
import com.server.server.api.model.Person;
import com.server.server.api.repositories.PersonRepository;
import com.server.server.api.services.PersonService;
import com.server.server.unitTests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    MockPerson mockPerson;

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private Mapper mapper;

    @BeforeEach
    public void setup() {
        mockPerson = new MockPerson();

        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() throws Exception {
        final List<Person> personList = mockPerson.mockEntityList();

        when(personRepository.findAll()).thenReturn(personList);

        final List<PersonVO> voList = personService.findAll();

        final PersonVO vo1 = voList.get(1);

        assertNotNull(vo1);
        assertNotNull(vo1.getUniqueKey());
        assertEquals("First Name Test1", vo1.getFirstName());
        assertEquals("Last Name Test1", vo1.getLastName());
        assertEquals("Addres Test1", vo1.getAddress());
        assertEquals("Female", vo1.getGender());
        assertNotNull(vo1.getLinks());
        assertTrue(vo1.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));

        final PersonVO vo4 = voList.get(3);

        assertNotNull(vo4);
        assertNotNull(vo4.getUniqueKey());
        assertEquals("First Name Test4", vo4.getFirstName());
        assertEquals("Last Name Test4", vo4.getLastName());
        assertEquals("Addres Test4", vo4.getAddress());
        assertEquals("Male", vo4.getGender());
        assertNotNull(vo4.getLinks());
        assertTrue(vo4.toString().contains("links: [</api/person/v1/4>;rel=\"self\"]"));

        final PersonVO vo14 = voList.get(13);

        assertNotNull(vo14);
        assertNotNull(vo14.getUniqueKey());
        assertEquals("First Name Test14", vo14.getFirstName());
        assertEquals("Last Name Test14", vo14.getLastName());
        assertEquals("Addres Test14", vo4.getAddress());
        assertEquals("Male", vo4.getGender());
        assertNotNull(vo4.getLinks());
        assertTrue(vo4.toString().contains("links: [</api/person/v1/14>;rel=\"self\"]"));
    }

    @Test
    public void testFindById() throws Exception {
        final Person person = mockPerson.mockEntity(1);
        person.setId(1L);

        when(personRepository.findById(anyLong())).thenReturn(Optional.of(person));

        final PersonVO vo = personService.findById(1L);

        assertNotNull(vo);
        assertNotNull(vo.getUniqueKey());
        assertEquals("First Name Test1", vo.getFirstName());
        assertEquals("Last Name Test1", vo.getLastName());
        assertEquals("Addres Test1", vo.getAddress());
        assertEquals("Female", vo.getGender());
        assertNotNull(vo.getLinks());
        assertTrue(vo.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
    }

    @Test
    public void testCreate() throws Exception {
        final Person personEntity = mockPerson.mockEntity(1);

        personEntity.setId(1L);

        final PersonVO vo = mockPerson.mockVO(1);
        vo.setUniqueKey(1L);

        when(personRepository.save(personEntity)).thenReturn(personEntity);

        final PersonVO personVO = personService.create(vo);

        assertNotNull(personVO);
        assertNotNull(personVO.getUniqueKey());
        assertEquals("First Name Test1", personVO.getFirstName());
        assertEquals("Last Name Test1", personVO.getLastName());
        assertEquals("Addres Test1", personVO.getAddress());
        assertEquals("Female", personVO.getGender());
        assertNotNull(personVO.getLinks());
        assertTrue(personVO.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
    }

    @Test
    public void testCreateNullPerson() {
        final Exception ex = assertThrows(RequiredObjectIsNullException.class, () -> personService.create(null));

        final String expectedMessage = "It is not allowed to persist a null object.";
        final String actualMessage = ex.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testUpdate() throws Exception {
        final Person personEntity = mockPerson.mockEntity(1);
        personEntity.setId(1L);

        final PersonVO vo = mockPerson.mockVO(1);
        vo.setUniqueKey(1L);

        when(personRepository.findById(1L)).thenReturn(Optional.of(personEntity));
        when(personRepository.save(personEntity)).thenReturn(personEntity);

        final PersonVO personVO = personService.update(vo);

        assertNotNull(personVO);
        assertNotNull(personVO.getUniqueKey());
        assertEquals("First Name Test1", personVO.getFirstName());
        assertEquals("Last Name Test1", personVO.getLastName());
        assertEquals("Addres Test1", personVO.getAddress());
        assertEquals("Female", personVO.getGender());
    }

    @Test
    public void testUpdateNullPerson() {
        final Exception ex = assertThrows(RequiredObjectIsNullException.class, () -> personService.update(null));

        final String expectedMessage = "It is not allowed to persist a null object.";
        final String actualMessage = ex.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testDelete() {
        final Person person = mockPerson.mockEntity(1);
        person.setId(1L);

        when(personRepository.findById(1L)).thenReturn(Optional.of(person));

        personService.delete(1L);
    }
}