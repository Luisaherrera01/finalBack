package com.Final.Final.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private String nombre;

    @Column(name="volumenZona")
    private String volumenZona;
    @OneToMany(mappedBy = "zona")
    @JsonBackReference
    private List<Mercancia>mercancias;
    @Transient
    private String mensajeError;

    public Zona() {
    }

    public Zona(Integer id, String nombre,  String volumenZona, List<Mercancia> mercancias, String mensajeError) {
        this.id = id;
        this.nombre = nombre;

        this.volumenZona = volumenZona;
        this.mercancias = mercancias;
        this.mensajeError = mensajeError;
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



    public String getVolumenZona() {
        return volumenZona;
    }

    public void setVolumenZona(String volumenZona) {
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
