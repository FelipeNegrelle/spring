package com.server.server.api.mapper;

import com.server.server.api.data.vo.v1.PersonVO;
import com.server.server.api.model.Person;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    private static final ModelMapper mapper = new ModelMapper();

    static {
        mapper.createTypeMap(Person.class, PersonVO.class).addMapping(Person::getId, PersonVO::setUniqueKey);

        mapper.createTypeMap(PersonVO.class, Person.class).addMapping(PersonVO::getUniqueKey, Person::setId);
    }

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
        final List<D> destinationObjects = new ArrayList<>();

        for (O o : origin) {
            destinationObjects.add(parseObject(o, destination));
        }

        return destinationObjects;
    }
}
