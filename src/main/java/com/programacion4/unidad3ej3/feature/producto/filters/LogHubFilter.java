package com.programacion4.unidad3ej3.feature.producto.filters;

import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.LogRequestDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.ILogClientService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LogHubFilter extends OncePerRequestFilter {

    private final ILogClientService logClientService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        filterChain.doFilter(request, response);

        try {

            LogRequestDto dto = new LogRequestDto();

            dto.setAppId(7L);

            dto.setLogLevel(
                    response.getStatus() >= 400 ? "ERROR" : "INFO");

            dto.setMessage(
                    request.getMethod()
                            + " "
                            + request.getRequestURI()
                            + " -> "
                            + response.getStatus());

            logClientService.sendLog(dto);

        } catch (Exception e) {
            System.out.println("Error enviando log a LogHub");
        }
    }
}