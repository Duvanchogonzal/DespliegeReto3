/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3reto3.reto3.repository;

import com.ciclo3reto3.reto3.modelo.Reservation;
import com.ciclo3reto3.reto3.repository.crud.ReservationCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Duvan
 */

    @Repository
public class RepositorioReservation{
    @Autowired
    private ReservationCrudRepository crud;


    public List<Reservation>getAll(){
        return (List<Reservation>)crud.findAll();
    }

    public Optional<Reservation>getReservation(int id){
        return crud.findById(id);
    }

    public Reservation save(Reservation rsvt){
        return crud.save(rsvt);
    }
    public void delete(Reservation rsvt){
        crud.delete(rsvt);
        
    }
}

