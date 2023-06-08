package com.Final.Final.Service;


import com.Final.Final.Entity.Zona;
import com.Final.Final.Repository.ZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZonaService implements GenerateService<Zona>{
    @Autowired
    protected ZonaRepository zonaRepository;


    @Override
    public List<Zona> searchAll() throws Exception {
        try {
            List<Zona>zonas=zonaRepository.findAll();
            return zonas;

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Zona searchforId(Integer id) throws Exception {
       try{
           Optional<Zona> zonaOptional=zonaRepository.findById(id);
               if(zonaOptional.isPresent()){
                   return  zonaOptional.get();
               }else{
                   throw new Exception("zona no encontrada");
               }
           }catch (Exception error){
               throw new Exception(error.getMessage());
           }
    }

    @Override
    public Zona register(Zona record) throws Exception {
        try {
            Zona zonaGuardada= (Zona)zonaRepository.save(record);
            return zonaGuardada;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Zona update(Integer id, Zona datanew) throws Exception {
        Optional<Zona> zonaOptional = zonaRepository.findById(id);
        try {
            if (zonaOptional.isPresent()) {
                Zona zonaExistente = zonaOptional.get();
                zonaExistente.setNombre(datanew.getNombre());
                zonaExistente.setVolumenZona(datanew.getVolumenZona());
                Zona zonaActualizada = (Zona)zonaRepository.save(zonaExistente);
                return zonaActualizada;
            } else {
                throw new Exception("zona no encontrada");
            }
    } catch (Exception error) {
        throw new Exception(error.getMessage());
        }
    }


    @Override
    public boolean delete(Integer id) throws Exception {
        try {
            Optional<Zona> zonaOptional = zonaRepository.findById(id);
            if (zonaOptional.isPresent()) {
                zonaRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("zona no encotrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
