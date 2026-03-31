package com.programacion4.unidad3ej3.feature.producto.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoDeleteService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/productos")

public class ProductoDeleteController {
    private final IProductoDeleteService productoDeleteService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoDeleteService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

}
