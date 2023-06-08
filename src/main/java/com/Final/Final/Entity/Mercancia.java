package com.Final.Final.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name="mercancias")

public class Mercancia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  Integer id;
    @Column(name="nombres")
    private String nombre;
    @Column(name="descripcion")
    private  String descripcion;
    @Column(name="fecha")
    private String fecha;
    @Column(name="motivoDevolucion")
    private  String motivoDevolucion;
    @Column(name="volumen")
    private String volumen;
    @ManyToOne
    @JoinColumn (name="id_zona")
    @JsonManagedReference
    private Zona zona;

    public Mercancia() {
    }

    public Mercancia(Integer id, String nombre, String descripcion, String fecha, String motivoDevolucion, String volumen, Zona zona) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.motivoDevolucion = motivoDevolucion;
        this.volumen = volumen;
        this.zona = zona;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMotivoDevolucion() {
        return motivoDevolucion;
    }

    public void setMotivoDevolucion(String motivoDevolucion) {
        this.motivoDevolucion = motivoDevolucion;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }
}
