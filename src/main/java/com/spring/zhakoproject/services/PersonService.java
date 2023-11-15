package com.spring.zhakoproject.services;

import com.spring.zhakoproject.entities.Person;

import java.util.List;

public interface PersonService {
    Person addPerson(Person person);
    List<Person> getAllPersons();
    Person getPerson(Long id);
    void deletePerson(Person person);
    Person saveItem(Person person);
}
