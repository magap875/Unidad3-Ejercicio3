package com.programacion4.unidad3ej3.feature.producto.filters;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.LogRequestDto;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LogHubFilter extends OncePerRequestFilter {

    private final RestTemplate restTemplate;

    private static final String LOGHUB_URL =
            "http://localhost:8080/logs";

    private static final String API_KEY =
            "0ff5ea29-a2d1-4043-b5c7-4776db70b7d7";

    private static final Long APP_ID = 7L;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        filterChain.doFilter(request, response);

        try {

            LogRequestDto dto = new LogRequestDto();

            dto.setAppId(APP_ID);

            dto.setLogLevel(
                    response.getStatus() >= 400
                            ? "ERROR"
                            : "INFO");

            dto.setMessage(
                    request.getMethod()
                            + " "
                            + request.getRequestURI()
                            + " -> "
                            + response.getStatus());

            HttpHeaders headers = new HttpHeaders();

            headers.setContentType(MediaType.APPLICATION_JSON);

            headers.set("X-API-KEY", API_KEY);

            HttpEntity<LogRequestDto> entity =
                    new HttpEntity<>(dto, headers);

            restTemplate.postForEntity(
                    LOGHUB_URL,
                    entity,
                    Void.class);

        } catch (Exception e) {

            System.out.println(
                    "Error enviando log a LogHub");
        }
    }
}
