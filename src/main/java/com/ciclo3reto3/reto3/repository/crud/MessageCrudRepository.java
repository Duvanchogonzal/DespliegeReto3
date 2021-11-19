/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3reto3.reto3.repository.crud;

import com.ciclo3reto3.reto3.modelo.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Duvan
 */
public interface MessageCrudRepository extends CrudRepository <Message, Integer>  {
    
}
