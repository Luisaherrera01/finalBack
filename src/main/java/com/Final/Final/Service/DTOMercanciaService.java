package com.Final.Final.Service;

import com.Final.Final.DTO.DTOClienteMercancia;
import com.Final.Final.Entity.Mercancia;
import com.Final.Final.Mapper.MapsMercancia;
import com.Final.Final.Repository.MercanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DTOMercanciaService implements DTOServicioBase<Mercancia, DTOClienteMercancia>{

    @Autowired
    protected MercanciaRepository mercanciaRepository;
    @Autowired
    protected MapsMercancia mapsMercancia;

    @Override
    public List<DTOClienteMercancia> searchAll() throws Exception {
       try {
           List<DTOClienteMercancia>mercanciaEncontrada=mapsMercancia.mapearMercanciasParaCliente(mercanciaRepository.findAll());
           return mercanciaEncontrada;
       }catch (Exception error){
           throw new Exception(error.getMessage());
       }
    }

    @Override
    public DTOClienteMercancia searchforId(Integer id) throws Exception {
        return null;
    }

    @Override
    public DTOClienteMercancia register(Mercancia record) throws Exception {
        return null;
    }

    @Override
    public DTOClienteMercancia update(Integer id, Mercancia datanew) throws Exception {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return false;
    }
}
