package com.spring.zhakoproject.repositories;

import com.spring.zhakoproject.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PersonRepo extends JpaRepository<Person, Long> {
    Person findByName(String name);
    Person findByPassword(String password);
}
