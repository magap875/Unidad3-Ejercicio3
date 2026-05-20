package com.programacion4.unidad3ej3.feature.producto.dtos.request;

import lombok.Data;

@Data
public class LogRequestDto {
    private String message;
    private String logLevel;
    private Long appId;
}
