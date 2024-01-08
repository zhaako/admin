package com.spring.zhakoproject.repositories;

import com.spring.zhakoproject.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Repository
@Transactional
public interface CategoryRepo extends JpaRepository<Categories, Long>{
}
