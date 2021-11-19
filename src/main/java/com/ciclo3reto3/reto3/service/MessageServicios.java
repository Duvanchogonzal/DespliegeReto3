/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3reto3.reto3.service;

import com.ciclo3reto3.reto3.modelo.Message;
import com.ciclo3reto3.reto3.repository.RepositorioMessage;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Duvan
 */
@Service
public class MessageServicios {
    @Autowired
    private RepositorioMessage messageRepositorio;

    public List<Message>getAll(){
        return messageRepositorio.getAll();
    }

    public Optional<Message>getMessage(int id){
        return messageRepositorio.getMessage(id);
    }

    public Message save(Message msge){
        if (msge.getIdMessage()==null){
            return messageRepositorio.save(msge);

        }else{
            Optional<Message> consulta=messageRepositorio.getMessage(msge.getIdMessage());
            if (consulta.isEmpty()) {
                return messageRepositorio.save(msge);
            } else {
                return msge;
            }
        }
    }

    public Message update(Message msge){
        if(msge.getIdMessage()!=null){
            Optional<Message> consulta=messageRepositorio.getMessage(msge.getIdMessage());
            if(!consulta.isEmpty()){
                if(msge.getMessageText()!=null){
                    consulta.get().setMessageText(msge.getMessageText());
                }
                return messageRepositorio.save(consulta.get());
            }
        }
        return msge;
    }
    public boolean deleteMessage(int idMessage){
        Optional<Message> consulta=messageRepositorio.getMessage(idMessage);
            if (!consulta.isEmpty()) {
                messageRepositorio.delete(consulta.get());
                return true;

            }
        return false;
    }
}
