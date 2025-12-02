package com.aaliyah.sakila.manager;

import java.util.List;

public interface CrudManager<T> {
    void post(T obj);           
    T get(int id);              
    List<T> get(String filter); 
    void put(T obj);            
    void delete(int id);        
}
