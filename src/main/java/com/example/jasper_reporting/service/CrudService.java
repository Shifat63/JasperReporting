package com.example.jasper_reporting.service;

import java.util.Set;

public interface CrudService<T, Id>
{
    Set<T> findAll() throws Exception;
    T findById(Id id) throws Exception;
}

