/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3reto3.reto3.service;

import com.ciclo3reto3.reto3.modelo.Client;
import com.ciclo3reto3.reto3.repository.RepositorioClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Duvan
 */
@Service
public class ClientServicios {
    @Autowired
    private RepositorioClient clientRepositorio;

    public List<Client>getAll(){
        return clientRepositorio.getAll();
    }

    public Optional<Client>getClient(int id){
        return clientRepositorio.getClient(id);
    }

    public Client save(Client clie){
        if (clie.getIdClient()==null){
            return clientRepositorio.save(clie);

        }else{
            Optional<Client> consulta=clientRepositorio.getClient(clie.getIdClient());
            if (consulta.isEmpty()) {
                return clientRepositorio.save(clie);
            } else {
                return clie;
            }
        }
    }

    public Client update(Client clie){
        if(clie.getIdClient()!=null){
            Optional<Client> consulta=clientRepositorio.getClient(clie.getIdClient());
            if(!consulta.isEmpty()){
                if(clie.getEmail()!=null){
                    consulta.get().setEmail(clie.getEmail());
                }
                if(clie.getPassword()!=null){
                    consulta.get().setPassword(clie.getPassword());
                }
                if(clie.getName()!=null){
                    consulta.get().setName(clie.getName());
                }
                if(clie.getAge()!=null){
                    consulta.get().setAge(clie.getAge());
                }
                return clientRepositorio.save(consulta.get());
            }
        }
        return clie;
    }
    public boolean deleteClient(int idClient){
        Optional<Client> consulta=clientRepositorio.getClient(idClient);
            if (!consulta.isEmpty()) {
                clientRepositorio.delete(consulta.get());
                return true;

            }
        return false;
    } 
}
