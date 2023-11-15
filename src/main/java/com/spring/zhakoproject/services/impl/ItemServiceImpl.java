package com.spring.zhakoproject.services.impl;

import com.spring.zhakoproject.entities.Items;
import com.spring.zhakoproject.repositories.ItemRepo;
import com.spring.zhakoproject.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Override
    public Items addItem(Items item) {
        return itemRepo.save(item);
    }

    @Override
    public List<Items> getAllItem() {
        return itemRepo.findAll();
    }

    @Override
    public Items getItem(Long id) {
        return itemRepo.getOne(id);
    }

    @Override
    public void deleteItem(Items item) {
        itemRepo.delete(item);
    }

    @Override
    public Items saveItem(Items item) {
        return itemRepo.save(item);
    }
}
