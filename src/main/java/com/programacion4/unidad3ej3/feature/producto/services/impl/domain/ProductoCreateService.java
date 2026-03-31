package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import com.programacion4.unidad3ej3.config.exceptions.BadRequestException;
import org.springframework.stereotype.Service;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoCreateService;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoCreateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.commons.IProductoExistByNameService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class ProductoCreateService implements IProductoCreateService {

    private final IProductoExistByNameService productoExistByNameService;
    private final IProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    @Override
    public ProductoResponseDto create(ProductoCreateRequestDto dto) {

        if (productoExistByNameService.existByName(dto.getNombre())) {
            throw new BadRequestException("El nombre del producto ya existe");
        }

        // capitalizo antes de guardar
        dto.setNombre(capitalizar(dto.getNombre()));
        dto.setDescripcion(capitalizar(dto.getDescripcion()));

        Producto productoAGuardar = ProductoMapper.toEntity(dto);

        Producto productoGuardado = productoRepository.save(productoAGuardar);

        return productoMapper.toResponseDto(productoGuardado);
    }

    private String capitalizar(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto;
        }
        texto = texto.toLowerCase();
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }
}
