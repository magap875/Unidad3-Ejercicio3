package com.programacion4.unidad3ej3.feature.producto.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoPatchService;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoPatchRequestDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/productos")

public class ProductoPatchController {
    private final IProductoPatchService productoPatchService;

    @PatchMapping("/{id}")
    public ResponseEntity<ProductoResponseDto> actualizarParcialmente(@PathVariable Long id,
            @Valid @RequestBody ProductoPatchRequestDto dto) {
        return ResponseEntity.ok(productoPatchService.actualizarParcialmente(id, dto));
    }
}
