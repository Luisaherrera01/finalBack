package com.Final.Final.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


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
    @Column(name="fechaDeEntrada")
    private String fechaDeEntrada;
    @Column(name="motivoDevolucion")
    private  String motivoDevolucion;
    @Column(name="volumen")
    private Double volumen;

    @Transient
    private String mensajeError;
    @ManyToOne
    @JoinColumn (name="id_zona")
    @JsonBackReference
    private Zona zona;

    public Mercancia() {
    }

    public Mercancia(Integer id, String nombre, String descripcion, String fechaDeEntrada, String motivoDevolucion, Double volumen, Zona zona) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaDeEntrada = fechaDeEntrada;
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

    public String getFechaDeEntrada() {
        return fechaDeEntrada;
    }

    public void setFechaDeEntrada(String fechaDeEntrada) {
        this.fechaDeEntrada = fechaDeEntrada;
    }

    public String getMotivoDevolucion() {
        return motivoDevolucion;
    }

    public void setMotivoDevolucion(String motivoDevolucion) {
        this.motivoDevolucion = motivoDevolucion;
    }

    public Double getVolumen() {
        return volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
}
