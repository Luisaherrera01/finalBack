package com.Final.Final.Service;

import com.Final.Final.Entity.Mercancia;
import com.Final.Final.Repository.MercanciaRepository;
import com.Final.Final.Repository.ZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MercanciaService implements GenerateService<Mercancia>{
    @Autowired
    protected MercanciaRepository mercanciaRepository;
    @Autowired
    protected ZonaRepository zonaRepository;


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

            Double volumenDeMercancia = record.getVolumen();
            int idDeZona = record.getZona().getId();
            Double volumenDeZona = zonaRepository.findById(idDeZona).get().getVolumenZona();


            if(volumenDeMercancia < volumenDeZona){
               Mercancia mercanciaRegistrada =  mercanciaRepository.save(record);
                return mercanciaRegistrada  ;
            }else{
                throw new Exception("No hay espacio en la zona");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public Double restarVolumenZona (Double volumenZona, Double volumenMercancia) {
        return (volumenZona - volumenMercancia);
    }


    @Override
    public Mercancia update(Integer id, Mercancia datanew) throws Exception {
        Optional<Mercancia> mercanciaOptional = mercanciaRepository.findById(id);
        try {
            if (mercanciaOptional.isPresent()) {
                Mercancia mercanciaExistente = mercanciaOptional.get();
                mercanciaExistente.setNombre(datanew.getNombre());
                mercanciaExistente.setDescripcion(datanew.getDescripcion());
                mercanciaExistente.setFechaDeEntrada(datanew.getFechaDeEntrada());
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
