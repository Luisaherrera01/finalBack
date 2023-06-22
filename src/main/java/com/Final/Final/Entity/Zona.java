package com.Final.Final.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="zonas")
public class Zona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="nombre")
    private String nombre = "Bodega";

    @Column(name="volumenZona")
    private Double volumenZona;
    @OneToMany(mappedBy = "zona")
    @JsonManagedReference
    private List<Mercancia>mercancias;
    @Transient
    private String mensajeError;

    public Zona() {
    }

    public Zona(Integer id, String nombre,  Double volumenZona, List<Mercancia> mercancias) {
        this.id = id;
        this.nombre = nombre;
        this.volumenZona = volumenZona;
        this.mercancias = mercancias;
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



    public Double getVolumenZona() {
        return volumenZona;
    }

    public void setVolumenZona(Double volumenZona) {
        this.volumenZona = volumenZona;
    }

    public List<Mercancia> getMercancias() {
        return mercancias;
    }

    public void setMercancias(List<Mercancia> mercancias) {
        this.mercancias = mercancias;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
