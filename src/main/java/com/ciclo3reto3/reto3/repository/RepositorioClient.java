/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3reto3.reto3.repository;

import com.ciclo3reto3.reto3.modelo.Client;
import com.ciclo3reto3.reto3.repository.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Duvan
 */
@Repository
public class RepositorioClient {
    @Autowired
    
    private ClientCrudRepository crud;
    public List<Client>getAll(){
        return (List<Client>)crud.findAll();
    }

    public Optional<Client>getClient(int id){
        return crud.findById(id);
    }

    public Client save(Client clie){
        return crud.save(clie);
 
    }
    public void delete(Client clie){
        crud.delete(clie);
    }
    
}
