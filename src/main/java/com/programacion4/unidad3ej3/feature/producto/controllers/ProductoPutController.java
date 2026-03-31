package com.programacion4.unidad3ej3.feature.producto.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoUpdateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoPutService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/productos")

public class ProductoPutController {
    private final IProductoPutService productoPutService;

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDto> reemplazar(@PathVariable Long id,
            @Valid @RequestBody ProductoUpdateRequestDto dto) {
        return ResponseEntity.ok(productoPutService.reemplazar(id, dto));
    }

}
