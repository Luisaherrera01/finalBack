package com.Final.Final.Controller;

import com.Final.Final.DTO.DTOClienteMercancia;
import com.Final.Final.Entity.Mercancia;
import com.Final.Final.Service.DTOMercanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/version1/mercanciasdto")
public class DTOControllerMercancia {
    @Autowired
    protected DTOMercanciaService dtoMercanciaService;
    @GetMapping
    public ResponseEntity<List<DTOClienteMercancia>> searchAll() {
        try {
            List<DTOClienteMercancia> mercancias = dtoMercanciaService.searchAll();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercancias);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}
