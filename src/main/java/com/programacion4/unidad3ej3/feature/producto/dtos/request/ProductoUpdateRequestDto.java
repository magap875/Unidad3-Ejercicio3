package com.programacion4.unidad3ej3.feature.producto.dtos.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoUpdateRequestDto {

    @NotNull(message = "El nombre es requerido")
    private String nombre;

    @NotNull(message = "El código es requerido")
    private String codigo;

    @NotNull(message = "La descripción es requerida")
    private String descripcion;

    @NotNull(message = "El precio es requerido")
    private Double precio;

    @NotNull(message = "El stock es requerido")
    private Integer stock;
}
