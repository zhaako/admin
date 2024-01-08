package com.spring.zhakoproject.services;

import com.spring.zhakoproject.entities.Gender;
import com.spring.zhakoproject.entities.Person;

import java.util.List;

public interface PersonService {
    Person addPerson(Person person);
    List<Person> getAllPersons();
    Person getPerson(String name);
    Person getOnePerson(Long id);

    boolean doesPersonExist(String name, String password);

    void deletePerson(Person person);
    Person saveItem(Person person);


    List<Gender> getAllGender();
    Gender addGender(Gender gender);
    Gender saveGender(Gender gender);
    Gender getGender(Long id);
}
