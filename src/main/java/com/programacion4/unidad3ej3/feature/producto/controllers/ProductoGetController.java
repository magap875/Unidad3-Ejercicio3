package com.programacion4.unidad3ej3.feature.producto.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import lombok.AllArgsConstructor;
import java.util.List;
import com.programacion4.unidad3ej3.config.BaseResponse;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoGetService;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor

public class ProductoGetController {
    private final IProductoGetService productoGetService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<ProductoResponseDto>>> findAll() {

        return ResponseEntity.ok(
                BaseResponse.ok(
                        productoGetService.findAll(),
                        "Listado de productos"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDto> obtenerPorIdPath(@PathVariable Long id) {
        return ResponseEntity.ok(productoGetService.obtenerPorId(id));
    }
}
