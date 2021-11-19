/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3reto3.reto3.web;

import com.ciclo3reto3.reto3.modelo.Message;
import com.ciclo3reto3.reto3.service.MessageServicios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Duvan
 */
@RestController
@RequestMapping("api/Message")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT} )

public class MessageWeb {
    @Autowired
    private  MessageServicios messageServicio;
    
    @GetMapping("/all")
    public List<Message>getMessage(){
        return messageServicio.getAll();
    }

    @GetMapping("/{idMessage}")
    public Optional<Message>getMessage(@PathVariable("idMessage") int id){
        return messageServicio.getMessage(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message msge){
        return messageServicio.save(msge);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message msge){
        return messageServicio.update(msge);
    }

    @DeleteMapping("/{idMessage}") // rojo: el atributo de la clase
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteMessage(@PathVariable("idMessage") int idMessage){ //azul:servicio
        return messageServicio.deleteMessage(idMessage);
    } 
}
