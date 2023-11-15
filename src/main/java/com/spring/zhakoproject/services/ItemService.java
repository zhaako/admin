package com.spring.zhakoproject.services;

import com.spring.zhakoproject.entities.Items;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ItemService {
    Items addItem(Items item);
    List<Items> getAllItem();
    Items getItem(Long id);
    void deleteItem(Items item);
    Items saveItem(Items item);
}
