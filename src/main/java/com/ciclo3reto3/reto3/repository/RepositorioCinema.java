/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3reto3.reto3.repository;

import com.ciclo3reto3.reto3.modelo.Cinema;
import com.ciclo3reto3.reto3.repository.crud.interfaceCinema;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Duvan
 */
@Repository
public class RepositorioCinema {
    @Autowired
    private interfaceCinema crud;
    
    public List <Cinema> getAll(){
        return (List<Cinema>) crud.findAll();
    }
    
    public Optional <Cinema> getcinema(int id){
        return crud.findById(id);
    }

    public Cinema save(Cinema cine){
        return crud.save(cine);
    }
    public void delete(Cinema cine){
      crud.delete(cine);
    }
    
}
