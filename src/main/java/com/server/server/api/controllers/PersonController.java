package com.server.server.api.controllers;

import com.server.server.api.data.vo.v1.PersonVO;
import com.server.server.api.data.vo.v2.PersonVOV2;
import com.server.server.api.services.PersonService;
import com.server.server.utils.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/person/v1")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_X_YAML}
    )
    public List<PersonVO> findAll() throws Exception {
        return personService.findAll();
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_X_YAML}
    )
    public PersonVO findById(@PathVariable(value = "id") long id) throws Exception {
        return personService.findById(id);
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_X_YAML},
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_X_YAML}
    )
    public PersonVO create(@RequestBody PersonVO person) throws Exception {
        return personService.create(person);
    }

    @PostMapping(
            value = "/v2",
            consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_X_YAML},
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_X_YAML}
    )
    public PersonVOV2 createV2(@RequestBody PersonVOV2 person) throws Exception {
        return personService.createV2(person);
    }

    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_X_YAML},
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_X_YAML}
    )
    public PersonVO update(@RequestBody PersonVO person) throws Exception {
        return personService.update(person);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    public ResponseEntity<?> delete(@PathVariable(value = "id") long id) throws Exception {
        personService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
