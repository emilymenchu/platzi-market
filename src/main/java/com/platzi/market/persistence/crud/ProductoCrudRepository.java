package com.platzi.market.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import com.platzi.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

    //Optional<List<Producto>> findByNombreStartingWith(String letras);

    //Optional<List<Producto>> findByIdStartingWith(int idProducto);

    //Optional<List<Producto>> findByPrecioVentaBetween(double startingPrice, double finalPrince);

   // Optional<List<Producto>> findByPrecioVentaLessThan(double precioVenta);

    //Optional<List<Producto>> findByPrecioVentaGreaterThan(double precioVenta);

    //Optional<List<Producto>> findByCodigoBarrasStartingWith(String codigoBarras);

    //Optional<Producto> getProducto(int idProducto);

    Producto save(Producto producto);
    void deleteById(int idProducto);
}
