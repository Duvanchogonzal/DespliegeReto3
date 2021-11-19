/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3reto3.reto3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Duvan
 */
@Entity
@Table(name = "category")
public class Category implements Serializable{
    
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    //Relación uno a muchos (una categoria muchos cinemas)
     @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy="category")
    @JsonIgnoreProperties("category")
    private List<Cinema> cinemas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Cinema> getCine() {
        return cinemas;
    }

    public void setCine(List<Cinema> cine) {
        this.cinemas = cine;
    }

    
}
