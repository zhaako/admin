package com.spring.zhakoproject.repositories;

import com.spring.zhakoproject.entities.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ItemRepo extends JpaRepository<Items,Long>{
}
