package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_fornecedores")
@Data
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String razaoSocial;
    private String cnpj;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String tipo;
    private String logradouro;
    private String numero;
    private String atividades;
    private String email;
    private String telefone;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fornecedor_id")
    private List<Representante> representante = new ArrayList<>();

    public Fornecedor() {
    }

    public Fornecedor(String razaoSocial, String cnpj, String cep, String estado, String cidade, String bairro, String tipo, String logradouro, String numero, String atividades, String email, String telefone, List<Representante> representante) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.atividades = atividades;
        this.email = email;
        this.telefone = telefone;
        this.representante = representante;
    }

    public Fornecedor(String razaoSocial, String cnpj, String cep, String estado, String cidade, String bairro, String tipo, String logradouro, String numero, String atividades, String email, String telefone) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.atividades = atividades;
        this.email = email;
        this.telefone = telefone;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAtividades() {
        return atividades;
    }

    public void setAtividades(String atividades) {
        this.atividades = atividades;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Representante> getRepresentante() {
        return representante;
    }

    public void setRepresentante(List<Representante> representante) {
        this.representante = representante;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "id=" + id +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", cep='" + cep + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", tipo='" + tipo + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", atividades='" + atividades + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", representante=" + representante +
                '}';
    }

}
