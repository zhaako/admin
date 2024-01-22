package com.spring.zhakoproject.services.impl;

import com.spring.zhakoproject.entities.Gender;
import com.spring.zhakoproject.entities.Person;
import com.spring.zhakoproject.repositories.GenderRepo;
import com.spring.zhakoproject.repositories.PersonRepo;
import com.spring.zhakoproject.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private GenderRepo genderRepo;


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
    public Person getOnePerson(Long id) {
        return personRepo.getOne(id);
    }

    @Override
    public boolean doesPersonExist(String login, String password) {
        Person person = personRepo.findByLogin(login);
        return person != null && person.getPassword().equals(password);
    }

    @Override
    public void deletePerson(Person person) {
        personRepo.delete(person);
    }

    @Override
    public Person saveItem(Person person) {
        return personRepo.save(person);
    }



    @Override
    public List<Gender> getAllGender() {
        return genderRepo.findAll();
    }

    @Override
    public Gender addGender(Gender gender) {
        return genderRepo.save(gender);
    }

    @Override
    public Gender saveGender(Gender gender) {
        return genderRepo.save(gender);
    }

    @Override
    public Gender getGender(Long id) {
        return genderRepo.getOne(id);
    }
}
