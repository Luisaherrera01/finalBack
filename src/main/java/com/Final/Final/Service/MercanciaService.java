package com.Final.Final.Service;

import com.Final.Final.Entity.Mercancia;
import com.Final.Final.Entity.Zona;
import com.Final.Final.Repository.MercanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MercanciaService implements GenerateService<Mercancia>{
    @Autowired
    protected MercanciaRepository mercanciaRepository;


    @Override
    public List<Mercancia> searchAll() throws Exception {
        try{
            List<Mercancia>mercancias= (List<Mercancia>) mercanciaRepository.findAll();
            return mercancias;

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Mercancia searchforId(Integer id) throws Exception {
        try{
            Optional<Mercancia> mercanciaOptional=mercanciaRepository.findById(id);
            if(mercanciaOptional.isPresent()){
                return  mercanciaOptional.get();
            }else{
                throw new Exception("mercancia no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Mercancia register(Mercancia record) throws Exception {
        try {
            Mercancia mercanciaGuardada= (Mercancia) mercanciaRepository.save(record);
            return mercanciaGuardada;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Mercancia update(Integer id, Mercancia datanew) throws Exception {
        Optional<Mercancia> mercanciaOptional = mercanciaRepository.findById(id);
        try {
            if (mercanciaOptional.isPresent()) {
                Mercancia mercanciaExistente = mercanciaOptional.get();
                mercanciaExistente.setNombre(datanew.getNombre());
                mercanciaExistente.setDescripcion(datanew.getDescripcion());
                mercanciaExistente.setFecha(datanew.getFecha());
                mercanciaExistente.setMotivoDevolucion(datanew.getMotivoDevolucion());
                mercanciaExistente.setVolumen(datanew.getVolumen());
                Mercancia mercanciaActualizada = (Mercancia)mercanciaRepository.save(mercanciaExistente);
                return mercanciaActualizada;
            } else {
                throw new Exception("mercancia no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        try {
            Optional<Mercancia> mercanciaOptional = mercanciaRepository.findById(id);
            if (mercanciaOptional.isPresent()) {
                mercanciaRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("mercancia no encotrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
