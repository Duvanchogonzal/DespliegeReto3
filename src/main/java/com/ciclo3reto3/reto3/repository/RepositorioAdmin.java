/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3reto3.reto3.repository;

import com.ciclo3reto3.reto3.modelo.Admin;
import com.ciclo3reto3.reto3.repository.crud.AdminCrudRepositoy;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Duvan
 */
@Repository
public class RepositorioAdmin {
    @Autowired
    
    private AdminCrudRepositoy crud;
    
    public List <Admin> getAll(){
        return (List<Admin>) crud.findAll();
    }
    
    public Optional <Admin> getadmin(int id){
        return crud.findById(id);
    }

    public Admin save(Admin admin){
        return crud.save(admin);
    }
    public void delete( Admin admin){
        crud.delete(admin);
    }
    
}
