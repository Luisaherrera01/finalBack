package com.Final.Final.Mapper;

import com.Final.Final.DTO.DTOClienteMercancia;
import com.Final.Final.Entity.Mercancia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring")
public interface MapsMercancia {
    @Mappings({
            //source es el nombre del atributo en la entidad y el tarje es el nombre del atributo en el dto
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "descripcion", target = "descripcion")

    })
    public DTOClienteMercancia mapearMercanciaParaCliente(Mercancia mercancia);
    public List<DTOClienteMercancia> mapearMercanciasParaCliente(List<Mercancia>mercancias);

}
