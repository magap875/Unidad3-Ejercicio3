package com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain;

import com.programacion4.unidad3ej3.feature.producto.dtos.request.LogRequestDto;

public interface ILogClientService {
    void sendLog(LogRequestDto dto);
}
