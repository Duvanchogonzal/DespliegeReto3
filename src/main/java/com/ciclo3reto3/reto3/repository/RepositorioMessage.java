/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3reto3.reto3.repository;

import com.ciclo3reto3.reto3.modelo.Message;
import com.ciclo3reto3.reto3.repository.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Duvan
 */
@Repository
public class RepositorioMessage {
    @Autowired
    
    private MessageCrudRepository crud;
    
     public List<Message>getAll(){
        return (List<Message>)crud.findAll();
    }

    public Optional<Message>getMessage(int id){
        return crud.findById(id);
    }

    public Message save(Message msge){
        return crud.save(msge);
    }
    public void delete(Message msge){
        crud.delete(msge);
    }
    
}
