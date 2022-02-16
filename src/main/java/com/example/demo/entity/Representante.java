package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Representante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;

    @ManyToOne(fetch = FetchType.LAZY)
    private Fornecedor fornecedor;

    @OneToOne
    private Cargo cargo;

    public Representante() {
    }

    public Representante(String nome, String cpf, Fornecedor fornecedor, Cargo cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.fornecedor = fornecedor;
        this.cargo = cargo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }


    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Representante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", fornecedor=" + fornecedor +
                ", cargo=" + cargo +
                '}';
    }
}
