package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel="spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source="idCategoria", target="categoryId"),
            @Mapping(source="descripcion", target="category"),
            @Mapping(source="estado", target="active")
    })
    Category toCategory (Categoria categoria);
    List<Category> toCategory(List<Categoria> categorias);

    @InheritInverseConfiguration
    @Mapping(target="productos", ignore = true)
    Categoria toCategoria(Category category);
}
