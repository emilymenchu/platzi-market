package com.platzi.market.domain.repository;

import com.platzi.market.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    List<Category> findAll();

    Optional<Category> findById(Integer categoryId);

    Category save(Category category);

    void delete(Integer categoryId);
}
