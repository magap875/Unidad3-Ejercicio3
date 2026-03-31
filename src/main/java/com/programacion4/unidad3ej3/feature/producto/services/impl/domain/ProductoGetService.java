package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import java.util.List;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.config.exceptions.NotFoundException;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoGetService;

@Service
@AllArgsConstructor

public class ProductoGetService implements IProductoGetService {
    private final IProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    @Override
    public List<ProductoResponseDto> findAll() {
        List<Producto> productos = (List<Producto>) productoRepository.findByEstaEliminadoFalse();

        return productos.stream()
                .map(productoMapper::toResponseDto)
                .toList();
    }

    @Override
    //@Transactional(readOnly = true) se puede poner en metodos q no requieran insertar datos
    public ProductoResponseDto obtenerPorId(Long id){
        Producto producto = productoRepository.findByIdAndEstaEliminadoFalse(id)
            .orElseThrow(() -> new NotFoundException("Producto no encontrado"));
        //new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado.")); //preguntarle al profe
        return productoMapper.toResponseDto(producto);
    }
}
