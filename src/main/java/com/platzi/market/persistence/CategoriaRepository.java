package com.platzi.market.persistence;

import com.platzi.market.domain.Category;
import com.platzi.market.domain.repository.CategoryRepository;
import com.platzi.market.persistence.crud.CategoriaCrudRepository;
import com.platzi.market.persistence.entity.Categoria;
import com.platzi.market.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository implements CategoryRepository {

    @Autowired
    private CategoriaCrudRepository crudRepository;

    @Autowired
    private CategoryMapper mapper;
    @Override
    public List<Category> findAll() {
        return mapper.toCategory((List<Categoria>) crudRepository.findAll());
    }

    @Override
    public Optional<Category> findById(Integer categoryId) {
        return crudRepository.findById(categoryId).map(categoria -> mapper.toCategory(categoria));
    }

    @Override
    public Category save(Category category) {
        Categoria categoria = mapper.toCategoria(category);
        return mapper.toCategory(crudRepository.save(categoria));
    }

    @Override
    public void delete(Integer categoryId) {
        crudRepository.deleteById(categoryId);
    }
}
