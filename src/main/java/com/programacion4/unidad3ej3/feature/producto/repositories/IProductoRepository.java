package com.programacion4.unidad3ej3.feature.producto.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;

@Repository
public interface IProductoRepository extends CrudRepository<Producto, Long> {

    boolean existsByNombre(String nombre);
    List<Producto> findByEstaEliminadoFalse();
    Optional<Producto> findByIdAndEstaEliminadoFalse(Long id);
}
