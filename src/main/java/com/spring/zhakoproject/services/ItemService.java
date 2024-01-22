package com.spring.zhakoproject.services;

import com.spring.zhakoproject.entities.Categories;
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

    List<Items> getAllOrdItem();
    List<Items> saveAllItem(List<Items> items);


    List<Items> finding(String text);


    List<Categories> getAllCategories();
    Categories getCategory(Long id);
    Categories saveCategory(Categories category);
    Categories addCategory(Categories category);
    void deleteCategory(Categories category);
}
