package com.practica1.Laptops.Models;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperties;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import jakarta.persistence.*;

@Entity
@Table(name="Laptops")
@Schema(description = "A partir de este modelo laptop se generaran las laptops necesarias",name = "CLASS MODEL LAPTOP")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Company;
    private String Model;

    public Laptop() {
    }

    public Laptop(Long id, String company, String model) {
        Id = id;
        Company = company;
        Model = model;
    }

    @Schema(description = "Clave ficticia auto-incremental de tipo Long")
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }



}
