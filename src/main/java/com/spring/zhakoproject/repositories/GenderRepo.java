package com.spring.zhakoproject.repositories;

import com.spring.zhakoproject.entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface GenderRepo extends JpaRepository<Gender, Long> {

}
