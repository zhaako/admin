package com.spring.zhakoproject.repositories;

import com.spring.zhakoproject.entities.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ItemRepo extends JpaRepository<Items,Long>{
    List<Items> findAllByAmountGreaterThanOrderByPriceDesc(int amount);
    List<Items> findAllByAmountGreaterThanOrderByPriceAsc(int amount);

    List<Items> findByNameLike(String text);
}
