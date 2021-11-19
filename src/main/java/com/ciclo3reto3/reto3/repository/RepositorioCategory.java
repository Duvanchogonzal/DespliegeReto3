/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3reto3.reto3.repository;

import org.springframework.stereotype.Repository;
import com.ciclo3reto3.reto3.modelo.Category;

import com.ciclo3reto3.reto3.repository.crud.CategoryCrudRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author Duvan
 */
@Repository
public class RepositorioCategory {
      @Autowired
    private CategoryCrudRepository crud;
    
    public List <Category> getAll(){
        return (List<Category>) crud.findAll();
    }
    
    public Optional <Category> getcategory(int id){
        return crud.findById(id);
    }

    public Category save(Category category){
        return crud.save(category);
    }
    public void delete(Category category){
        crud.delete(category);
    }
}

    
