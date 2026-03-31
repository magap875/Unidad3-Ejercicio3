package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.config.exceptions.NotFoundException;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoDeleteService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class ProductoDeleteService implements IProductoDeleteService {
    private final IProductoRepository productoRepository;

    @Override
    public void eliminarProducto(Long id){
        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Producto no encontrado"));
        producto.setEstaEliminado(true);
        productoRepository.save(producto);
        
    }
}