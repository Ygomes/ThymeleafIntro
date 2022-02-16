package com.example.demo.entity;


import javax.persistence.*;

@Entity
public class Cargo {

    @Id
    private Long id;
    private String name;

    public Cargo() {
    }

    public Cargo(String name) {
        this.name = name;
    }

    public Cargo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Cargo(String name, Representante representante) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String cargo) {
        this.name = cargo;
    }

    @Override
    public String toString() {
        return name;
    }
}
