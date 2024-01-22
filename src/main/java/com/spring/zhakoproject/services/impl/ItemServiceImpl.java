package com.spring.zhakoproject.services.impl;

import com.spring.zhakoproject.entities.Categories;
import com.spring.zhakoproject.entities.Items;
import com.spring.zhakoproject.repositories.CategoryRepo;
import com.spring.zhakoproject.repositories.ItemRepo;
import com.spring.zhakoproject.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private CategoryRepo categoryRepo;

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

    @Override
    public List<Items> getAllOrdItem() {
        return itemRepo.findAllByAmountGreaterThanOrderByPriceAsc(0);
    }

    @Override
    public List<Items> saveAllItem(List<Items> items) {
        return itemRepo.saveAll(items);
    }

    @Override
    public List<Items> finding(String text) {
        return itemRepo.findByNameLike(text);
    }


    @Override
    public List<Categories> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Categories getCategory(Long id) {
        return categoryRepo.getOne(id);
    }

    @Override
    public Categories saveCategory(Categories category) {
        return categoryRepo.save(category);
    }

    @Override
    public Categories addCategory(Categories category) {
        return categoryRepo.save(category);
    }

    @Override
    public void deleteCategory(Categories category) {
        categoryRepo.delete(category);
    }
}
