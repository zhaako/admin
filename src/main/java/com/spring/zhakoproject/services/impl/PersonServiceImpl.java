package com.spring.zhakoproject.services.impl;

import com.spring.zhakoproject.entities.Person;
import com.spring.zhakoproject.repositories.PersonRepo;
import com.spring.zhakoproject.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Override
    public Person addPerson(Person person) {
        return personRepo.save(person);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepo.findAll();
    }

    @Override
    public Person getPerson(Long id) {
        return personRepo.getOne(id);
    }

    @Override
    public void deletePerson(Person person) {
        personRepo.delete(person);
    }

    @Override
    public Person saveItem(Person person) {
        return personRepo.save(person);
    }
}
