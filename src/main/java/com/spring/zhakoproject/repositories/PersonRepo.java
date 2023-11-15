package com.spring.zhakoproject.repositories;

import com.spring.zhakoproject.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PersonRepo extends JpaRepository<Person, Long> {
    Person findByName(String name);
}
