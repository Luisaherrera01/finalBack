package com.Final.Final.Service;

import java.util.List;

public interface GenerateService<E> {

    public List<E> searchAll() throws Exception;


    public  E searchforId(Integer id)throws Exception;

    public E register(E record) throws Exception;


    public E update(Integer id,E datanew) throws Exception;


    public boolean delete(Integer id) throws Exception;
}
