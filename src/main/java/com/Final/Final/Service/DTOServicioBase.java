package com.Final.Final.Service;

import java.util.List;

public interface DTOServicioBase<E,DTO> {
    public List<DTO> searchAll() throws Exception;


    public  DTO searchforId(Integer id)throws Exception;

    public DTO register(E record) throws Exception;


    public DTO update(Integer id,E datanew) throws Exception;


    public boolean delete(Integer id) throws Exception;
}


