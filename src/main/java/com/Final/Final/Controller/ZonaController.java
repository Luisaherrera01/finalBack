package com.Final.Final.Controller;


import com.Final.Final.Entity.Mercancia;
import com.Final.Final.Entity.Zona;
import com.Final.Final.Service.ZonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/zonas")
public class ZonaController {

    @Autowired
    protected ZonaService zonaService;

    @PostMapping
    public ResponseEntity<Zona>register(@RequestBody Zona saveData){
        try{
            Zona zonaGuardada=zonaService.register(saveData);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(zonaGuardada);
        }catch (Exception error){
            String mensaje= "Existe un error al registrar"+error.getMessage();
            Zona zonaConError=new Zona();
            zonaConError.setMensajeError(mensaje);
            return ResponseEntity
                    .status((HttpStatus.BAD_REQUEST))
                    .body(zonaConError);

        }
    }
    @GetMapping
    public ResponseEntity <List<Zona>>searchAll(){
        try{
            List<Zona> zonas = zonaService.searchAll();

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(zonas);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity <Zona> searchforId(@PathVariable Integer id){
        try{
            Zona zonaEncontrada = zonaService.searchforId(id);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(zonaEncontrada);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}
