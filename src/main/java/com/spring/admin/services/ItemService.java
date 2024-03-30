package com.spring.admin.services;


import com.spring.admin.entities.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();
    Item saveItem(Item item);
    Item addItem(Item item);
    void deleteItem(Item item);
    Item getItem(Long id);
}
