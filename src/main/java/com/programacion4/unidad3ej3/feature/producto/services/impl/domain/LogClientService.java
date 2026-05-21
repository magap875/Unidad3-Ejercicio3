package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.LogRequestDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.ILogClientService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogClientService implements ILogClientService{

        private final RestTemplate restTemplate;

        private static final String LOGHUB_URL = "http://localhost:8080/logs";

        private static final String API_KEY = "0ff5ea29-a2d1-4043-b5c7-4776db70b7d7";

        @Async
        public void sendLog(LogRequestDto dto) {

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                headers.set("X-API-KEY", API_KEY);

                HttpEntity<LogRequestDto> entity = new HttpEntity<>(dto, headers);

                restTemplate.postForEntity(
                                LOGHUB_URL,
                                entity,
                                Void.class);
        }
}
