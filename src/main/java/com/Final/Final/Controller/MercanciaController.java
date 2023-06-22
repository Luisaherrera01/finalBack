package com.Final.Final.Controller;

import com.Final.Final.Entity.Mercancia;
import com.Final.Final.Service.MercanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/mercancias")

public class MercanciaController {
    @Autowired
    protected MercanciaService mercanciaService;

    @PostMapping
    public ResponseEntity<Mercancia> register(@RequestBody Mercancia saveData) {
        try {
            Mercancia mercanciaGuardada=mercanciaService.register(saveData);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(mercanciaGuardada);
        } catch (Exception error){
            String mensaje= "Existe un error al registrar"+error.getMessage();
            Mercancia mercanciaConError=new Mercancia();
            mercanciaConError.setMensajeError(mensaje);
            return ResponseEntity
                    .status((HttpStatus.BAD_REQUEST))
                    .body(mercanciaConError);
        }
    }

    @GetMapping
    public ResponseEntity <List<Mercancia>>searchAll(){
        try{
            List<Mercancia> mercancias=mercanciaService.searchAll();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercancias);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}