package com.platzi.market.domain.service;

import com.platzi.market.domain.Category;
import com.platzi.market.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Optional<Category> findById(Integer categoryId) {
        return repository.findById(categoryId);
    }

    public Category save(Category category) {
        category.setCategory(category.getCategory().toUpperCase());
        return repository.save(category);
    }

    public boolean delete(Integer categoryId) {
        return findById(categoryId).map(category -> {
                repository.delete(categoryId);
                return true;
        }).orElse(false);
    }

}
