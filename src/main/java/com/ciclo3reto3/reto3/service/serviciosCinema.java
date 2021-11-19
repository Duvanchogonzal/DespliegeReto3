/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3reto3.reto3.service;


import com.ciclo3reto3.reto3.repository.RepositorioCinema;
import com.ciclo3reto3.reto3.modelo.Cinema;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Duvan
 */

@Service
public class serviciosCinema {
    @Autowired
    private RepositorioCinema metodosCrud;
    
    public List<Cinema> getAll(){
        return metodosCrud.getAll();
    } 
    
    public Optional<Cinema>getCinema(int idCinema){
        return metodosCrud.getcinema(idCinema); 
    }
    
    public Cinema save (Cinema cine){
        if (cine.getId()==null){
            return metodosCrud.save(cine);

        }else{
            Optional<Cinema> evt=metodosCrud.getcinema(cine.getId());
            if (evt.isEmpty()) {
                return metodosCrud.save(cine);
            } else {
                return cine;
            }
        }
        
    }
    
}

