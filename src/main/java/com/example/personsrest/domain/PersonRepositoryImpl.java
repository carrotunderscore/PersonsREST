package com.example.personsrest.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.*;
import java.util.stream.Collectors;

public class PersonRepositoryImpl implements PersonRepository {

    Map<String, Person> persons = new HashMap<>();

    public PersonRepositoryImpl() {
        Person person = new PersonImpl("Arne Anka", 12, "Stad", List.of());
        persons.put(person.getId(), person);
    }


    @Override
    public Optional<Person> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(persons.values());
    }

    @Override
    public Page<Person> findAllByNameContainingOrCityContaining(String name, String city, Pageable pageable) {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Person save(Person person) {
        return null;
    }

    @Override
    public void delete(String id) {

    }


}
