/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3reto3.reto3.service;

import com.ciclo3reto3.reto3.modelo.Category;
import com.ciclo3reto3.reto3.repository.RepositorioCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Duvan
 */

@Service
public class ServiciosCategory {
    @Autowired
    private RepositorioCategory repositoriocategory;

    public List<Category>getAll(){
        return repositoriocategory.getAll();
    }

    public Optional<Category>getCategory(int id){
        return repositoriocategory.getcategory(id);
    }

    public Category save(Category catg){
        if (catg.getId()==null){
            return repositoriocategory.save(catg);

        }else{
            Optional<Category> consulta=repositoriocategory.getcategory(catg.getId());
            if (consulta.isEmpty()) {
                return repositoriocategory.save(catg);
            } else {
                return catg;
            }
        }
    }

    public Category update(Category catg){
        if(catg.getId()!=null){
            Optional<Category> consulta=repositoriocategory.getcategory(catg.getId());
            if(!consulta.isEmpty()){
                if(catg.getDescription()!=null){
                    consulta.get().setDescription(catg.getDescription());
                }
                if(catg.getName()!=null){
                    consulta.get().setName(catg.getName());
                }
                return repositoriocategory.save(consulta.get());
            }
        }
        return catg;
    }
    public boolean deleteCategory(int id){
        Optional<Category> consulta=repositoriocategory.getcategory(id);
            if (!consulta.isEmpty()) {
                repositoriocategory.delete(consulta.get());
                return true;

            }
        return false;
    }
}

    

